package karp.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MyInput {

    public static void main(String[] args) {


        Integer a =new Integer(123);
        Integer b =new Integer(123);
//        System.out.println(a.equals(b));
        System.out.println(a==b);
        System.out.println("-------------------------");

        Integer c =Integer.valueOf(123);
        Integer d =Integer.valueOf(123);
        System.out.println(c==d);



        int i = Integer.parseInt("123");//包装类用来类型转换。
        System.out.println(i);


        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        for (int x = 0; x < list.size(); x++) {
            String s = (String) list.get(x);
            if (s.equals("hello")) {
                list.add("world");
            }
        }
        //
        /**
         *  字节流 InputStream         OutputStream
         *  字符流 Reader              Writer
         */





//        Iterator<String> iterator = list.iterator();
//
//        while (iterator.hasNext()) {
//            String currentValue=iterator.next();
//            if (currentValue.equals("world"))
//            {
//                boolean remove = list.remove(currentValue);
//                System.out.println(remove);
//            }
//        }
        System.out.println("----------------------------------------");
        list.remove("hello");
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }

    // Read a string from the keyboard
    public static String readString() {
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in), 1);

        // Declare and initialize the string
        String string = " ";

        // Get the string from the keyboard
        try {
            string = br.readLine();

        } catch (IOException ex) {
            System.out.println(ex);
        }

        // Return the string obtained from the keyboard
        return string;
    }

    // Read an int value from the keyboard
    public static int readInt() {
        return Integer.parseInt(readString());
    }

    // Read a double value from the keyboard
    public static double readDouble() {
        return Double.parseDouble(readString());
    }

    // Read a byte value from the keyboard
    public static double readByte() {
        return Byte.parseByte(readString());
    }

    // Read a short value from the keyboard
    public static double readShort() {
        return Short.parseShort(readString());
    }

    // Read a long value from the keyboard
    public static double readLong() {
        return Long.parseLong(readString());
    }

    // Read a float value from the keyboard
    public static double readFloat() {
        return Float.parseFloat(readString());
    }

}
