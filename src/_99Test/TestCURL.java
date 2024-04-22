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

public class TestCURL {

    public static void main(String[] args) throws Exception {

        System.out.println("��������------>");
        // ǰ��:�Ѱ���or �߼����� ���ⶨ��udf�Ĺ���ɾ��
        Workbook wrb = Workbook.getWorkbook(new File("src/resources/test1.xls"));
        Sheet rs = wrb.getSheet(0);
        int cols = rs.getColumns();
        int rows = rs.getRows();
        System.out.println("����: " + (rows - 1));
        System.out.println("����: " + cols);


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

            JSONObject jsonReqBody = GetReqBody(id, rule_id, transformation, event_name, filter_dsl, action_tmp);
            System.out.println(id + ": "+ formatJson(jsonReqBody) + ",");
        }

//        String filterStr = input.get("play").get(0).get("filter_dsl");
//        JSONArray fliterList = GetFliterBFS(1, filterStr);
//        System.out.println(fliterList);
//
//        String actionStr = input.get("play").get(0).get("action_tem");
//        JSONArray actionList = GetAction(1, actionStr);
//        System.out.println(actionList);

        System.out.println("�������<------");

    }


    public static String formatJson(JSON json) {
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


    public static JSONObject GetReqBody(String id, String rule_id, String transformation, String event_name, String filter_dsl, String action_tmp) throws Exception {
        String init = GetInitJson();
        JSONObject reqBody = JSON.parseObject(init);
        JSONArray testList = new JSONArray();
        JSONObject test = new JSONObject();

        // TODO
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

    public static String GetInitJson() {
        int id = 245;
        String creator = "sunweiye.3";
        String json = "{\"test_case_suite_id\":" + id + ",\"creator\":\"" + creator + "\"}";
        return json;
    }



    public static JSONArray GetAction(String id, String json) throws Exception {
        JSONArray ret = new JSONArray();
        JSONArray input = JSON.parseArray(json);
//        if (json == null || input == null) {return ret;}
        for (int i = 0; i < input.size(); i++) {
        String s = input.getString(i);
        JSONObject jsonObject = new JSONObject();
        String field = GetFieldWithPat(s);
        jsonObject.put("key",field);
        jsonObject.put("description","");
        jsonObject.put("required", 1);
        String valueType = null;
        try {
            valueType = FunMatch(s);            // ��ȡֵ��Ӧ����������,����в���ʶ����������ͻᱨ��
        } catch (Exception e) {
            // TODO ����ǰ�ڿ��Բ���.��ӡ��������Ĺ�������
//                throw new Exception( "�������(����)id: " + id + "; " + e.getMessage());
            System.out.println("�������(����)id: " + id + "; " + e.getMessage());
        }
        jsonObject.put("value_type",valueType);
        ret.add(jsonObject);
    }
        return ret;
    }

    // ��ȡһ���Ĺ����Ӧ��array
    public static JSONArray GetFliterBFS(String id, String json) throws Exception {
        Queue<String> queue = new PriorityQueue<String>();
        queue.clear();
        queue.add(json);

        JSONArray ret = new JSONArray();
        // ֧�ֵ��жϷ���
        Set<String> opSet = new HashSet<String>(Arrays.asList("==", "!=", ">", "<", ">=", "<="));
        Set<String> opSet1 = new HashSet<String>(Arrays.asList("in", "not in"));

        while (!queue.isEmpty()) {
            String element = queue.poll();
            JSONObject json1 = JSON.parseObject(element);
//            if (element == null || json1 == null) {continue;}
            JSONArray jsonArray = json1.getJSONArray("clauses");

            for (int i = 0; i < jsonArray.size(); i++) {
                String s = jsonArray.getString(i);
                if (isYE(id, s)) {
                    queue.add(s);
                } else {
                    // �����������ݽڵ�
                    JSONObject s1 = JSON.parseObject(s);

                    if ("params".equals(s1.getString("field"))) {  // ֻ����params�е��ֶ�

                        try {
                            IsContainFun(s1.getString("func"));  // �ж��Ƿ���ڲ�֧�ֵ�UDF
                        } catch (Exception e) {
                            // TODO ����ǰ�ڿ��Բ���.��ӡ��������Ĺ�������
//                throw new Exception( "�������(����)id: " + id + "; " + e.getMessage());
                            System.out.println("�������(����)id: " + id + "; " + e.getMessage());
                        }
                        if (s1.getString("func").contains("containsKey(")) {
                            continue;
                        }

                        JSONObject jsonObject = new JSONObject();
                        // ��ȡ�ֶ���Ϣ
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
                            throw new Exception("��֧�ֵ�ǰ���ֲ�����:" + s1);
                        }
                        ret.add(jsonObject);
                    }
                }
            }
        }
        return ret;
    }

    public static Boolean isYE(String id, String jsonS) throws Exception {
        JSONObject jsonO = JSON.parseObject(jsonS);
        if (jsonO.containsKey("bool") && jsonO.containsKey("clauses")) {  // �ӽڵ�
            return true;
        } else if (jsonO.containsKey("field")) { // ���ݽڵ�
            return false;
        } else {
            throw new Exception("�������(����)id: " + id + "; " + "������: ����ʶ��ǰ��Ҳ�ӽڵ㻹�����ݽڵ� --> " + jsonS);
        }
    }

    // �����ȡ��һ��"" ˫����֮�������
    public static String GetField(String args) throws Exception {
        Pattern pattern = Pattern.compile("\\\"(.*?)\"");
        Matcher matcher = pattern.matcher(args);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new Exception("Filterû�в��ҵ�Ԫ��");
        }
    }

    // �����ȡ()֮�������,�����Ƴ�"˫����
    public static String GetFieldWithPat(String args) throws Exception {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(args);
        if (matcher.find()) {
            return matcher.group(1).trim().replace("\"","");
        } else {
            throw new Exception("Actionû�в��ҵ�Ԫ��");
        }
    }

    // �жϺ����Ƿ���֧�ֵķ�Χ��,�����֧�ֵĺ����򱨴�,����ӡ������
    public static boolean IsContainFun(String args) throws Exception {
        if (args.contains("getOrDefault(") || args.contains("get(") || args.contains("containsKey(")
        || args.contains("getStringWithDefaultValue(") || args.contains("getString(") || args.contains("getInt(")
        || args.contains("getInteger(") || args.contains("getLong(") || args.contains("getFloat(") || args.contains("getDouble(")) {
            return true;
        } else {
            throw new Exception("������֧�ִ�UDF: " + args);
        }
    }

    // ͨ����������������,��ȡ����������
    public static String FunMatch(String args) throws Exception {
        if (args.contains("toString(") || args.contains("toStringWithDefaultValue(") || args.contains("getOrDefault(") || args.contains("get(")
                || args.contains("getStringWithDefaultValue(") || args.contains("getString(")) {
            return "string";
        } else if (args.contains("toFloat(") || args.contains("toDouble(") || args.contains("getFloat(") || args.contains("getDouble(")) {
            return "float";
        } else if (args.contains("toInteger(") || args.contains("toLong(") || args.contains("getInt(") || args.contains("getInteger(") || args.contains("getLong(")) {
            return "integer";
        } else  {
            throw new Exception("������֧��ӳ��: " + args);
        }
    }

}
