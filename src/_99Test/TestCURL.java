package _99Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

public class TestCURL {
    public static void main(String[] args) throws Exception {

        System.out.println("��������------>");
        String json = "{\n" +
                "    \"bool\": \"and\",\n" +
                "    \"clauses\": [\n" +
                "        {\n" +
                "            \"bool\": \"and\",\n" +
                "            \"clauses\": [\n" +
                "                {\n" +
                "                    \"field\": \"params\",\n" +
                "                    \"func\": \".containsKey(\\\"video_id\\\")\",\n" +
                "                    \"op\": \"==\",\n" +
                "                    \"value\": \"true\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"field\": \"params\",\n" +
                "                    \"func\": \".getString(\\\"video_id\\\")\",\n" +
                "                    \"op\": \"!=\",\n" +
                "                    \"value\": \"\\\"0\\\"\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"field\": \"params\",\n" +
                "            \"func\": \"getOrDefault(\\\"enter_from\\\",\\\"\\\")\",\n" +
                "            \"op\": \"==\",\n" +
                "            \"value\": \"\\\"homepage_hot\\\"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"bool\": \"and\",\n" +
                "            \"clauses\": [\n" +
                "                {\n" +
                "                    \"field\": \"params\",\n" +
                "                    \"func\": \".getString(\\\"enter_from_merge\\\")\",\n" +
                "                    \"op\": \"in\",\n" +
                "                    \"value\": \"(\\\"video\\\",\\\"recommend\\\",\\\"city\\\",\\\"moment\\\")\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"bool\": \"and\",\n" +
                "            \"clauses\": [\n" +
                "                {\n" +
                "                    \"field\": \"params\",\n" +
                "                    \"func\": \".getString(\\\"action_type\\\")\",\n" +
                "                    \"op\": \"==\",\n" +
                "                    \"value\": \"\\\"draw\\\"\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Queue<String> queue = new PriorityQueue<String>();
        queue.add(json);

        ArrayList<String> reList = new ArrayList<String>(); // ���ڴ�Ž��
        BFS(json, queue, reList);

    }

    public static void BFS(String json, Queue<String> queue, List reList) throws Exception {

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
                }

            }

        }
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
