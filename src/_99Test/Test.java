package _99Test;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        String str = "[123,23,34]";
        HashSet set = JSONObject.parseObject(str, HashSet.class);

        long s = 123;
        int i = 123;
        System.out.println(set.contains((int)s));
        System.out.println(set.contains(i));
        System.out.println(set.contains(123));
        System.out.println(set.contains(1234));

    }
}
