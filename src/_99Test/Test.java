package _99Test;

import _00��������._02������;
import com.alibaba.fastjson.JSONObject;
import sun.lwawt.macosx.CPrinterDevice;

import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {

        int i = 2 << 29;

        System.out.println(i);

        int cap = 10;

        int seed = 3;

        int[] value = _02������.generateRandomArray(20, 20);

//        String value = ints;

        System.out.println(value);

        int h;
        System.out.println(Math.abs((cap - 1) & seed * ((h = value.hashCode()) ^ (h >>> 16))));

        int A = 3500; // �������
        int B = 10; // �ܳ���

        System.out.println(A & B);

        HashMap hs = new HashMap<>();
        hs.put("","");
    }
}
