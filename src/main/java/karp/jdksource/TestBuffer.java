package karp.jdksource;

import java.nio.Buffer;
import java.nio.CharBuffer;

/**
 * @Author: pjx
 * @Date: 2019/1/17 16:10
 * @Version 1.0
 */
public class TestBuffer {

    /**
     * Buffer中有3个很重要的变量

     capacity （总容量）

     position （指针当前位置）

     limit （读/写边界位置）
     * @param args
     */
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put('H');
        buffer.put('E');
        buffer.put('L');
        buffer.put('L');
        buffer.put('O');
        print(buffer);
        buffer.flip();
        print(buffer);
        System.out.println("---------------------------");
        while (buffer.hasRemaining())
        {
            System.out.println(buffer.get());
        }
        print(buffer);
        System.out.println(buffer.get(2));
        print(buffer);
        //        创建一个视图缓冲区，与原始缓冲区共享数据元素。操作会影响原始缓冲区。
        buffer.duplicate();
    }
    public static void print(Buffer buffer) {
        System.out.println("当前指针位置->position : " + buffer.position() + " 读写边界-->limit : " + buffer.limit() + " 总容量-->capacity : " + buffer.capacity());
    }
}
