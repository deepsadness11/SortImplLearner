package com.cry;

import java.lang.reflect.Proxy;

public class Main {

    private static NodeInner n1;
    private static NodeInner n2;
    private static NodeInner n3;
    private static NodeInner n4;
    private static NodeInner n5;

    public static void main(String[] args) {
        // write your code here
        n1 = new NodeInner(1);
        n2 = new NodeInner(2);
        n3 = new NodeInner(3);
        n4 = new NodeInner(4);
        n5 = new NodeInner(5);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printNode(n1);

//        //reverse node list
        Reverse1(n1);
        printNode(n5);

    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static NodeInner Reverse1(NodeInner head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        NodeInner reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
        System.out.println("head=" + head);
        System.out.println("reHead=" + reHead);
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    private static void printNode(NodeInner nodeInner) {
        System.out.print(nodeInner.data + "==>");
        NodeInner next = nodeInner.next;
        if (next != null) {
            printNode(next);
        } else {
            System.out.println("NULL");
            System.out.println("=====================================");
        }
    }

    static class NodeInner {
        int data;
        NodeInner next;

        public NodeInner(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public NodeInner getNext() {
            return next;
        }

        public void setNext(NodeInner next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "NodeInner{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
