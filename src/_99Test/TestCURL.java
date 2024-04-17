package _99Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

public class TestCURL {
    public static void main(String[] args) throws Exception {

        System.out.println("��������------>");

        // ǰ��:�Ѱ���or �߼����� ���ⶨ��udf�Ĺ���ɾ��

        Queue<String> queue = new PriorityQueue<String>();

        // input ��һ��map�ṹ,key��event_name,value��һ��list,ÿ��list��Ԫ������һ��ԭ��,������filter��action��Ϣ
        HashMap<String, ArrayList<HashMap<String, String>>> input = new HashMap<String, ArrayList<HashMap<String, String>>>();
        HashMap<String, String> rule1 = new HashMap<String, String>();
        rule1.put("rule_id", "1");
        rule1.put("id", "1");
        rule1.put("event_name", "play");
        rule1.put("filter_dsl", "{\"bool\":\"and\",\"clauses\":[{\"bool\":\"and\",\"clauses\":[{\"field\":\"params\",\"func\":\".containsKey(\\\"video_id\\\")\",\"op\":\"==\",\"value\":\"true\"},{\"field\":\"params\",\"func\":\".getString(\\\"video_id\\\")\",\"op\":\"!=\",\"value\":\"\\\"0\\\"\"}]},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"enter_from\\\",\\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"homepage_hot\\\"\"},{\"bool\":\"and\",\"clauses\":[{\"field\":\"params\",\"func\":\".getString(\\\"enter_from_merge\\\")\",\"op\":\"in\",\"value\":\"(\\\"video\\\",\\\"recommend\\\",\\\"city\\\",\\\"moment\\\")\"}]},{\"bool\":\"and\",\"clauses\":[{\"field\":\"params\",\"func\":\".getString(\\\"action_type\\\")\",\"op\":\"==\",\"value\":\"\\\"draw\\\"\"}]}]}");
        rule1.put("action_tem", "[\"getLong(group_id)\",\"getString(enter_from)\"]");
        HashMap<String, String> rule2 = new HashMap<String, String>();
        rule2.put("rule_id", "2");
        rule2.put("id", "2");
        rule2.put("event_name", "play");
        rule2.put("filter_dsl", "{\"bool\":\"and\",\"clauses\":[{\"field\":\"event.log_type\",\"op\":\"in\",\"value\":\"(\\\"mario_event\\\",\\\"css\\\",\\\"server\\\")\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"group_id\\\", \\\"0\\\")\",\"op\":\"!=\",\"value\":\"\\\"0\\\"\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"enter_from\\\",\\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"homepage_hot\\\"\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"enter_method\\\", \\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"comment_related_search\\\"\"},{\"field\":\"params\",\"func\":\"getOrDefault(\\\"is_success\\\",\\\"\\\")\",\"op\":\"==\",\"value\":\"\\\"1\\\"\"}]}");
        rule2.put("action_tem", "[\"getLong(group_id)\",\"getString(enter_from)\"]");


        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        list.add(rule1);
        list.add(rule2);


        for (int i = 0; i < list.size(); i++) {
            if (input.containsKey(list.get(i).get("event_name"))) {
                input.get(list.get(i).get("event_name")).add(list.get(i));
            } else {
                ArrayList<HashMap<String, String>> listTmp = new ArrayList<HashMap<String, String>>();
                listTmp.add(list.get(i));
                input.put(list.get(i).get("event_name") ,listTmp);
            }
        }

//        System.out.println(input);

        queue.clear();
        String json1 = input.get("play").get(0).get("filter_dsl");
        System.out.println("-----<<"+json1+"-----<<");
        queue.add(json1);


        GetFliterBFS(json1, queue);

    }

    public static JSONArray GetFliterBFS(String json, Queue<String> queue) throws Exception {
        JSONArray ret = new JSONArray();
        HashSet<String> opSet = new HashSet<String>();
        opSet.add("==");
        opSet.add("!=");
        opSet.add(">");
        opSet.add("<");
        opSet.add(">=");
        opSet.add("<=");
        HashSet<String> opSet1 = new HashSet<String>();
        opSet1.add("in");
        opSet1.add("not in");
//        opSet.add("");


        // ������в�Ϊ������Ҫ��������
        while (!queue.isEmpty()) {
            String element = queue.poll(); //��ȡһ������
            JSONObject json1 = JSON.parseObject(element);
            JSONArray jsonArray = json1.getJSONArray("clauses");

            for (int i = 0; i < jsonArray.size(); i++) {
                String s = jsonArray.getString(i);
                if (isYE(s)) {
                    // �����Ԫ�����ӽڵ���ӵ�������
                    queue.add(s);
                } else {
                    // �������Ԫ��������
                    JSONObject s1 = JSON.parseObject(s);
                    System.out.println(s1.getString("field"));
                    System.out.println(s1.getString("func"));
                    System.out.println(s1.getString("op"));
                    System.out.println(s1.getString("value"));
                    System.out.println("-------------------------->");

                    // ֻ����params�е��ֶ�
                    if ("params".equals(s1.getString("field"))) {
                        if (opSet.contains(s1.getString("op").trim())) {
                            JSONObject jsonObject = new JSONObject();

                            // ��ȡ�ֶ���Ϣ
                            String fieldTem = s1.getString("func");
                            fieldTem = fieldTem;


                            jsonObject.put("field","");
                            jsonObject.put("op",s1.getString("op"));
                            jsonObject.put("value",s1.getString("value"));
                            ret.add(jsonObject);

                        } else if (opSet1.contains(s1.getString("op").trim())) {

                        }
                    }
                }
            }
        }

        return ret;
    }



    // �жϵ�ǰ�Ľڵ���һ�����ݽڵ�,����һ��Ҷ�ӽڵ�
    public static Boolean isYE(String jsonS) throws Exception {
        JSONObject jsonO = JSON.parseObject(jsonS);
        if (jsonO.containsKey("bool") && jsonO.containsKey("clauses")) {
//            System.out.println("�ӽڵ�");
            return true;
        } else if (jsonO.containsKey("field")) {
//            System.out.println("���ݽڵ�");
            return false;
        } else {
//            System.out.println("������");
            return false;
        }
    }

}
