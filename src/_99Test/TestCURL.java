package _99Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Before;
import org.junit.Test;

public class TestCURL {

    int suite_id;
    String creator;
    File file;
    Boolean is_group_id_filter;
    Boolean is_check;

    @Before
    public void init() {
        // 测试数据集相关信息
        suite_id = 7205;
        creator = "sunweiye.3";
        // 文件地址
        file = new File("src/resources/33-not-or-2.xls");
        // 是否将group_id放到filter条件中
        is_group_id_filter = true;

        // 先检查是是否有失败的情况,然后在置为false,跑出脚本
        is_check = true;
    }

    @Test
    public void main() throws Exception {
        System.out.println("任务启动------>");
        // 前提:把包含or 逻辑符和 特殊定制udf的规则都删除
        Workbook wrb = Workbook.getWorkbook(file);
        Sheet rs = wrb.getSheet(0);
        int cols = rs.getColumns();
        int rows = rs.getRows();
        System.out.println("行数: " + (rows - 1));
        System.out.println("列数: " + cols);

        for (int i = 1; i < rows; i++) {
            String id = rs.getCell(0, i).getContents();
            String rule_id = rs.getCell(1, i).getContents();
            String transformation = rs.getCell(2, i).getContents();
            String event_name = rs.getCell(3, i).getContents();
            String filter_dsl = rs.getCell(4, i).getContents();
            String action_tmp = rs.getCell(8, i).getContents();
//            System.out.println("id:" + id);
//            System.out.println("rule_id:" + rule_id);
//            System.out.println("transformation:" + transformation);
//            System.out.println("event_name:" + event_name);
//            System.out.println("filter_dsl:" + filter_dsl);
//            System.out.println("action_tmp:" + action_tmp);
//            System.out.println("------------------------>" + i  + " id: " + id);

            if (id.isEmpty()) continue;
            JSONObject jsonReqBody = GetReqBody(id, rule_id, transformation, event_name, filter_dsl, action_tmp);
            if (!is_check) {
                System.out.println(id + ": "+ formatJson(jsonReqBody) + ",");
            }
        }
        System.out.println("任务完成<------");

    }


    public JSONObject GetReqBody(String id, String rule_id, String transformation, String event_name, String filter_dsl, String action_tmp) throws Exception {

        String init = "{\"test_case_suite_id\":" + suite_id + ",\"creator\":\"" + creator + "\"}";
        JSONObject reqBody = JSON.parseObject(init);
        JSONArray testList = new JSONArray();
        JSONObject test = new JSONObject();
        test.put("name", transformation + "->" + id);
        test.put("event_name", event_name);
        if (!GetFliterBFS(id, filter_dsl).isEmpty()) {
            JSONObject tem = new JSONObject();
            tem.put("bool","and");
            tem.put("clauses", GetFliterBFS(id, filter_dsl));
            test.put("filter_condition",tem);
        }

        if (!GetAction(id, action_tmp).isEmpty()) {
            JSONObject tem = new JSONObject();
            tem.put("bool","and");
            tem.put("clauses", GetAction(id, action_tmp));
            test.put("rule",tem);
        }

        testList.add(test);
        reqBody.put("test_cases", testList);
        return reqBody;

    }

    public JSONArray GetAction(String id, String json) throws Exception {
        JSONArray ret = new JSONArray();
        JSONArray input = JSON.parseArray(json);
        for (int i = 0; i < input.size(); i++) {
        String s = input.getString(i);
        JSONObject jsonObject = new JSONObject();
        String field = GetFieldWithPat(s);
        jsonObject.put("key",field);
        jsonObject.put("description","");
        jsonObject.put("required", 1);
        String valueType = null;
        try {
            valueType = FunMatch(s);   // 提取值对应的数据类型,如果有不能识别的数据类型会报错
        } catch (Exception e) {
            if (is_check) System.out.println("报错规则(主键)id: " + id + "; " + e.getMessage());
        }
        // TODO 将group_id和author_id字段主动置为String
        Set<String> setTem = new HashSet<String>(Arrays.asList("group_id", "author_id"));
        if (setTem.contains(field)) {
            valueType = "string";
        }
        jsonObject.put("value_type",valueType);
        ret.add(jsonObject);
    }
        return ret;
    }

    // 获取一个的规则对应的array
    public JSONArray GetFliterBFS(String id, String json) throws Exception {
        Queue<String> queue = new PriorityQueue<String>();
        queue.clear();
        queue.add(json);

        JSONArray ret = new JSONArray();
        // 支持的判断符号
        Set<String> opSet = new HashSet<String>(Arrays.asList("==", "!=", ">", "<", ">=", "<="));
        Set<String> opSet1 = new HashSet<String>(Arrays.asList("in", "not in"));

        while (!queue.isEmpty()) {
            String element = queue.poll();
            JSONObject json1 = JSON.parseObject(element);
            JSONArray jsonArray = json1.getJSONArray("clauses");

            if (jsonArray == null) continue;
            for (int i = 0; i < jsonArray.size(); i++) {
                String s = jsonArray.getString(i);
                if (isYE(id, s)) {
                    queue.add(s);
                } else {
                    // 处理数据数据节点
                    JSONObject s1 = JSON.parseObject(s);

                    if ("params".equals(s1.getString("field"))) {  // 只操作params中的字段

                        try {
                            IsContainFun(s1.getString("func"));  // 判断UDF是否合法
                        } catch (Exception e) {
                            if (is_check) System.out.println("报错规则(主键)id: " + id + "; " + e.getMessage());
                        }
                        // TODO 特殊处理逻辑,将包含containsKey函数的条件忽略不导入
                        if (s1.getString("func").contains("containsKey(")) {
                            continue;
                        } else if (!is_group_id_filter && "group_id".equals(GetField(s1.getString("func")))) {
                            continue;
                        }

                        JSONObject jsonObject = new JSONObject();
                        // 获取字段信息
                        String fieldTem = GetField(s1.getString("func"));
                        jsonObject.put("field",fieldTem);
                        jsonObject.put("op",s1.getString("op"));
                        if (opSet.contains(s1.getString("op").trim())) {
                            String valueTem = s1.getString("value").trim().replace("\"","");
                            jsonObject.put("value",valueTem);
                        } else if (opSet1.contains(s1.getString("op").trim())) {
                            String valueTem = s1.getString("value").trim();
                            valueTem = "[" + valueTem.substring(1,valueTem.length()-1) + "]";
                            jsonObject.put("value",valueTem);
                        } else {
                            throw new Exception("不支持当前这种操作符:" + s1);
                        }
                        ret.add(jsonObject);
                    }
                }
            }
        }
        return ret;
    }

    public Boolean isYE(String id, String jsonS) throws Exception {
        JSONObject jsonO = JSON.parseObject(jsonS);
        if (jsonO.containsKey("bool") && jsonO.containsKey("clauses")) {  // 子节点
            return true;
        } else if (jsonO.containsKey("field")) { // 数据节点
            return false;
        } else {
            throw new Exception("报错规则(主键)id: " + id + "; " + "处理报错: 不能识别当前是也子节点还是数据节点 --> " + jsonS);
        }
    }

    // 正则获取第一个"" 双引号之间的数据
    public String GetField(String args) throws Exception {
        Pattern pattern = Pattern.compile("\\\"(.*?)\"");
        Matcher matcher = pattern.matcher(args);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new Exception("Filter没有查找到元素");
        }
    }

    // 正则获取()之间的数据,并且移除"双引号
    public String GetFieldWithPat(String args) throws Exception {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(args);
        if (matcher.find()) {
            return matcher.group(1).trim().replace("\"","");
        } else {
            throw new Exception("Action没有查找到元素");
        }
    }

    // 判断函数是否在支持的范围内,如果不支持的函数则报错,并打印处理来
    public boolean IsContainFun(String args) throws Exception {
        if (args.contains("getOrDefault(") || args.contains("get(") || args.contains("containsKey(")
        || args.contains("getStringWithDefaultValue(") || args.contains("getString(") || args.contains("getInt(")
        || args.contains("getInteger(") || args.contains("getLong(") || args.contains("getFloat(")
        || args.contains("getDouble(") || args.contains("getJSONObject(")) {
            return true;
        } else {
            throw new Exception("函数不支持此UDF: " + args);
        }
    }

    // 通过给定出操作函数,提取出数据类型
    public String FunMatch(String args) throws Exception {
        if (args.contains("toString(") || args.contains("toStringWithDefaultValue(") || args.contains("getOrDefault(") || args.contains("get(")
                || args.contains("getStringWithDefaultValue(") || args.contains("getString(") || args.contains("getJSONObject(")) { // TODO getJSONObject按照string处理
            return "string";
        } else if (args.contains("toFloat(") || args.contains("toDouble(") || args.contains("getFloat(") || args.contains("getDouble(")) {
            return "float";
        } else if (args.contains("toInteger(") || args.contains("toLong(") || args.contains("getInt(") || args.contains("getInteger(") || args.contains("getLong(")) {
            return "integer";
        } else  {
            throw new Exception("函数不支持映射: " + args);
        }
    }

    public String formatJson(JSON json) {
        if (json == null) {
            return "";
        }

        String result;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>(1);
        map.put("JSON", json.toString());
        try {
            result = objectMapper.writeValueAsString(map.get("JSON"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }

}
