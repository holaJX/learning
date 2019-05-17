package karp.jdksource;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Author: pjx
 * @Date: 2019/1/17 16:05
 * @Version 1.0
 */
public class TestAtomicReferenceFieldUpdate {

    private static final AtomicReferenceFieldUpdater<Node, Node> NEXT_UPDATE = AtomicReferenceFieldUpdater
            .newUpdater(Node.class, Node.class, "next");  //第一个Node.class是field的持有对象类型，第二个是field的类型。


    public static void main(String[] args) {
        Node<Integer> integerNode= new Node<>(3);
        Node<Integer> integerNode1 =new Node<>(4);
        integerNode.next=integerNode1;

        NEXT_UPDATE.compareAndSet(integerNode, integerNode1, new Node(5));
        System.out.println(integerNode.next.item);
    }
}
class Node<E> {
    public final E item;
    /**
     * volatile修饰 内存可见性
     */
    public volatile Node<E> next;

    public Node(E item) {
        this.item = item;
    }
}