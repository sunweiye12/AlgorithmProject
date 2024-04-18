package _99Test;

import _00工具箱类._02对数器;
import com.alibaba.fastjson.JSONObject;
import sun.lwawt.macosx.CPrinterDevice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "getOrDefault(\"enter_from\",\"你好\")";
        Pattern pattern = Pattern.compile("\\\"(.*?)\"");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
