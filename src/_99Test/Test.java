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
        String str = "getOrDefault(\"enter_from\",\"���\")";
        Pattern pattern = Pattern.compile("\\\"(.*?)\"");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
