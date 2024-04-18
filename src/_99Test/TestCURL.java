package _99Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCURL {

    public static void main(String[] args) throws Exception {

        System.out.println("任务启动------>");
        // 前提:把包含or 逻辑符和 特殊定制udf的规则都删除
        // input 是一个map结构,key是event_name,value是一个list,每个list的元数代表一个原则,包含了filter和action信息
        HashMap<String, ArrayList<HashMap<String, String>>> input = new HashMap<String, ArrayList<HashMap<String, String>>>();
        HashMap<String, String> rule1 = new HashMap<String, String>();
        rule1.put("rule_id", "1");
        rule1.put("id", "1");
        rule1.put("transformation", "transformation_name");
        rule1.put("event_name", "play");
        rule1.put("filter_dsl", "{\"bool\":\"and\",\"clauses\":[{\"bool\":\"and\",\"clauses\":[{\"field\":\"params\",\"func\":\".containsKey(\\\"video_id\\\")\",\"op\":\"==\",\"value\":\"true\"},{\"field\":\"params\",\"func\":\".getString(\\\"video_id\\\")\",\"op\":\"!=\",\"value\":\"\\\"0\\\"\"}]},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"enter_from\\\",\\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"homepage_hot\\\"\"},{\"bool\":\"and\",\"clauses\":[{\"field\":\"params\",\"func\":\".getString(\\\"enter_from_merge\\\")\",\"op\":\"in\",\"value\":\"(\\\"video\\\",\\\"recommend\\\",\\\"city\\\",\\\"moment\\\")\"}]},{\"bool\":\"and\",\"clauses\":[{\"field\":\"params\",\"func\":\".getString(\\\"action_type\\\")\",\"op\":\"==\",\"value\":\"\\\"draw\\\"\"}]}]}");
        rule1.put("action_tem", "[\"getLong(group_id)\",\"getString(enter_from)\"]");
        HashMap<String, String> rule2 = new HashMap<String, String>();
        rule2.put("rule_id", "2");
        rule2.put("id", "2");
        rule1.put("transformation", "transformation_name");
        rule2.put("event_name", "play");
        rule2.put("filter_dsl", "{\"bool\":\"and\",\"clauses\":[{\"field\":\"event.log_type\",\"op\":\"in\",\"value\":\"(\\\"mario_event\\\",\\\"css\\\",\\\"server\\\")\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"group_id\\\", \\\"0\\\")\",\"op\":\"!=\",\"value\":\"\\\"0\\\"\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"enter_from\\\",\\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"homepage_hot\\\"\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"enter_method\\\", \\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"comment_related_search\\\"\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"is_success\\\",\\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"1\\\"\"}]}");
        rule2.put("action_tem", "[\"getLong(group_id)\",\"getString(enter_from)\"]");

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        list.add(rule1);
        list.add(rule2);

        // 汇总输入
        for (int i = 0; i < list.size(); i++) {
            if (input.containsKey(list.get(i).get("event_name"))) {
                input.get(list.get(i).get("event_name")).add(list.get(i));
            } else {
                ArrayList<HashMap<String, String>> listTmp = new ArrayList<HashMap<String, String>>();
                listTmp.add(list.get(i));
                input.put(list.get(i).get("event_name") ,listTmp);
            }
        }

//         验证fliter提去逻辑 并打印
        String filterStr = input.get("play").get(0).get("filter_dsl");
        JSONArray fliterList = GetFliterBFS(1, filterStr);
        System.out.println(fliterList);
//
//        String actionStr = input.get("play").get(0).get("action_tem");
//        System.out.println(actionStr);
//        JSONArray actionList = GetAction(1, actionStr);
//        System.out.println(actionList);

        System.out.println("任务完成<------");

    }

    public static JSONArray GetAction(int id, String json) throws Exception {
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
                valueType = FunMatch(s);            // 提取值对应的数据类型,如果有不能识别的数据类型会报错
            } catch (Exception e) {
                // TODO 这里前期可以不抛.打印出有问题的规则数量
//                throw new Exception( "报错规则(主键)id: " + id + "; " + e.getMessage());
                System.out.println("报错规则(主键)id: " + id + "; " + e.getMessage());
            }
            jsonObject.put("value_type",valueType);
            ret.add(jsonObject);
        }
        return ret;
    }

    // 获取一个的规则对应的array
    public static JSONArray GetFliterBFS(int id, String json) throws Exception {
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

            for (int i = 0; i < jsonArray.size(); i++) {
                String s = jsonArray.getString(i);
                if (isYE(id, s)) {
                    // 将这个子节点添加到队列中
                    queue.add(s);
                } else {
                    // 处理数据数据节点
                    JSONObject s1 = JSON.parseObject(s);
                    System.out.println(s1);
                    try {
                        IsContainFun(s1.getString("func"));                    // 判断是否存在不支持的UDF
                    } catch (Exception e) {
                        // TODO 这里前期可以不抛.打印出有问题的规则数量
//                throw new Exception( "报错规则(主键)id: " + id + "; " + e.getMessage());
                        System.out.println("报错规则(主键)id: " + id + "; " + e.getMessage());
                    }
                    if (s1.getString("func").startsWith(".containsKey(")) {
                        continue;
                    }
                    if ("params".equals(s1.getString("field"))) {                    // 只操作params中的字段
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


    public static Boolean isYE(int id, String jsonS) throws Exception {
        JSONObject jsonO = JSON.parseObject(jsonS);
        if (jsonO.containsKey("bool") && jsonO.containsKey("clauses")) {
            // 子节点
            return true;
        } else if (jsonO.containsKey("field")) {
            // 数据节点
            return false;
        } else {
            throw new Exception("报错规则(主键)id: " + id + "; " + "处理报错: 不能识别当前是也子节点还是数据节点 --> " + jsonS);
        }
    }

    // 正则获取第一个"" 双引号之间的数据
    public static String GetField(String args) throws Exception {
        Pattern pattern = Pattern.compile("\\\"(.*?)\"");
        Matcher matcher = pattern.matcher(args);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new Exception("Filter没有查找到元素");
        }
    }

    // 正则获取()之间的数据,并且移除"双引号
    public static String GetFieldWithPat(String args) throws Exception {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(args);
        if (matcher.find()) {
            return matcher.group(1).trim().replace("\"","");
        } else {
            throw new Exception("Action没有查找到元素");
        }
    }

    // 判断函数是否在支持的范围内,如果不支持的函数则报错,并打印处理来
    public static boolean IsContainFun(String args) throws Exception {
        if (args.contains("getOrDefault(") | args.contains("get(") | args.contains("containsKey(")
        | args.contains("getStringWithDefaultValue(") | args.contains("getString(") | args.contains("getInt(")
        | args.contains("getInteger(") | args.contains("getLong(") | args.contains("getFloat(") | args.contains("getDouble(")) {
            return true;
        } else {
            throw new Exception("函数不支持此UDF: " + args);
        }
    }

    // 通过给定出操作函数,提取出数据类型
    public static String FunMatch(String args) throws Exception {
        if (args.contains("toString(")) {
            return "string";
        } else if (args.contains("toFloat(")) {
            return "float";
        } else if (args.contains("toDouble(")) {
            return "float";
        } else if (args.contains("toInteger(")) {
            return "integer";
        } else if (args.contains("toLong(")) {
            return "integer";
        } else if (args.contains("toStringWithDefaultValue(")) {
            return "string";
        // TODO 注意下面两个按照string来处理
        } else if (args.contains("getOrDefault(")) {
            return "string";
        } else if (args.contains("get(")) {
            return "string";
        } else if (args.contains("getStringWithDefaultValue(")) {
            return "string";
        } else if (args.contains("getString(")) {
            return "string";
        } else if (args.contains("getInt(")) {
            return "integer";
        } else if (args.contains("getInteger(")) {
            return "integer";
        } else if (args.contains("getLong(")) {
            return "integer";
        } else if (args.contains("getFloat(")) {
            return "float";
        } else if (args.contains("getDouble(")) {
            return "float";
        } else  {
            throw new Exception("函数不支持映射: " + args);
        }
    }

}
