package karp.编码;

import java.io.UnsupportedEncodingException;

/**
 * @Author: pjx
 * @Date: 2018/12/21 16:37
 * @Version 1.0
 */
public class Encoding {
    public static void main(String[] args) {

        String name = "I am 君山";
        toHex(name.toCharArray());
        try {
            toHex(name.getBytes("iso-8859-1"));
            toHex(name.getBytes("gb2312"));
            toHex(name.getBytes("gbk"));
            toHex(name.getBytes("utf-16"));  //会打印一feff开头，是utf-16中的格式
            toHex(name.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private static void toHex(char[] chars) {
        System.out.println("chars -->for");
        for (char c : chars) System.out.print(" " + Integer.toHexString(c));
        System.out.println();
    }

    private static void toHex(byte[] buffer) {
        System.out.println("buffer -->for");
        String h = "";
        for (int i = 0; i < buffer.length; i++) {
            String temp = Integer.toHexString(buffer[i] & 0xFF);
            if (temp.length() == 1) {
                temp = "0" + temp;
            }
            h = h + " " + temp;
        }
        System.out.println(h);
    }
}