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

        String str = "([长度] + [高度]) * [倍数] - [减号] / [除号] > [大于号] < [小于号] == [等号] ";
        String regx = "\\[(.*?)]";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
