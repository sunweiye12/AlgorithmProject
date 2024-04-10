package _99Test;

import org.junit.Test;

public class TestCamel2Snake {

    @Test
    public void testCamel2Snake() {
        System.out.println("showPage_MiniVideoDetailPage => " + underscoreName("showPage_MiniVideoDetailPage"));
        System.out.println("leavePage_MiniVideoDetailPage => " + underscoreName("leavePage_MiniVideoDetailPage"));
        System.out.println("showPage_xigua => "+underscoreName("showPage_xigua"));
        System.out.println("leavePage_xigua => "+underscoreName("leavePage_xigua"));
        System.out.println("showPage_xigua_live => "+underscoreName("showPage_xigua_live"));
        System.out.println("leavePage_xigua_live => "+underscoreName("leavePage_xigua_live"));
    }


    public String underscoreName(String name) {

        if(name == null || name.length() == 0)
            return "";

        if (!(name.startsWith("showPage_")||name.startsWith("leavePage_")))
            return name;

        StringBuilder tmp = new StringBuilder(name);

        if (name.endsWith("Page")) {
            tmp = new StringBuilder(tmp.substring(0, tmp.length() - 4));
        }

        if (name.startsWith("s")) {
            tmp.delete(0,9);
            if (tmp.toString().contains("_")) return tmp + "_page_show";
            tmp.append("PageShow");
        } else {
            tmp.delete(0,10);
            if (tmp.toString().contains("_")) return tmp + "_page_live";
            tmp.append("PageLeave");
        }

        StringBuilder result = new StringBuilder();
        // ����һ���ַ������Сд
        result.append(tmp.substring(0, 1).toLowerCase());
        // ѭ�����������ַ�
        for (int i = 1; i < tmp.length(); i++) {
            String s = tmp.substring(i, i + 1);
            // �ڴ�д��ĸǰ����»���
            if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                result.append("_");
            }
            // �����ַ�ֱ��ת��Сд
            result.append(s.toLowerCase());
        }

        return result.toString();
    }
}
