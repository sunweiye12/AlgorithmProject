package _99Test;

import _00��������._02������;
import com.alibaba.fastjson.JSONObject;
import sun.lwawt.macosx.CPrinterDevice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String str = "([����] + [�߶�]) * [����] - [����] / [����] > [���ں�] < [С�ں�] == [�Ⱥ�] ";
        String regx = "\\[(.*?)]";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
