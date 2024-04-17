package _99Test;

import okhttp3.*;

import java.io.IOException;

public class TestCURL {
    public static void main(String[] args) throws Exception {

        System.out.println("��������------>");
        String url = "https://data-boe.bytedance.net/byteio/open/v1/test_case_suite/test_case/batch_create";
        String json = "{\"test_case_suite_id\":240,\"creator\":\"zhaozhirong\",\"test_cases\":[{\"name\":\"play����5\",\"event_name\":\"play\",\"filter_condition\":{\"bool\":\"and\",\"clauses\":[{\"field\":\"enter_from\",\"op\":\"==\",\"value\":\"test2\"},{\"field\":\"page_name\",\"op\":\"!=\",\"value\":12}]},\"rule\":{\"bool\":\"and\",\"clauses\":[{\"key\":\"duration\",\"description\":\"\",\"required\":1,\"value_type\":\"integer\"}]}}]}";

        postForJson(url, json);
    }

    public static void postForJson(String url, String json) throws Exception{
        // 1 ��ȡOkHttpClient����
        OkHttpClient client = new OkHttpClient();
        // 2 ��������
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        // 3 ���� request
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("x-operate-platform-token", "c7de211d-b880-454f-b688-a0c7cf440d25")
                .addHeader("operator", "zhaozhirong")
                .addHeader("content-type", "application/json;charset=UTF-8")
                .build();

        // 4 ��Request��װΪCall
        Call call = client.newCall(request);


        // 5 ͬ������
        Response response = call.execute();
        if (response!=null && response.isSuccessful()){
            // ...
            if (response.code() != 200) {
                System.out.println("�ϱ�ʧ��: " + response.message());
            } else {
                System.out.println("�ϱ��ɹ�: " + response.message());
            }
        }


//        // 5 �첽����
//        call.enqueue(new Callback() {
//            public void onFailure(Call call, IOException e) {
//                // ...
//                System.out.println("http��������: " + e.getMessage());
//            }
//            public void onResponse(Call call, final Response response) throws IOException {
//                if (response!=null && response.isSuccessful()){
//                    // ...
//                    if (response.code() != 200) {
//                        System.out.println("�ϱ�ʧ��: " + response.message());
//                    } else {
//                        System.out.println("�ϱ��ɹ�: " + response.message());
//                    }
//                }
//            }
//        });
    }
}
