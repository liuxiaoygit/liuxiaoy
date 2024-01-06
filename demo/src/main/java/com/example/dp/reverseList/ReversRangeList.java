package com.example.dp.reverseList;

public class ReversRangeList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node tail = head;
        for (int i = 2; i < 8; i++) {
            Node item = new Node(i);
            tail.setNext(item);
            tail = item;
        }
        //Node node = reverseList(head, 2, 4);
        Node node1 = reverseList2(head, 3, 5);
        //System.out.println(node.getVal());
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    static Node reverseList(Node head, int m, int n) {
        Node dummyNode = new Node(-1);
        dummyNode.next = head;

        Node pre = dummyNode;
        //1.走left-1步到left的前一个节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        //2.走roght-left+1步到right节点
        Node rigthNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rigthNode = rigthNode.next;
        }

        //3.截取出一个子链表
        Node leftNode = pre.next;
        Node cur = rigthNode.next;
        //4.切断链接
        pre.next = null;
        rigthNode.next = null;

        //5.反转局部链表
        reverseSubList(leftNode);

        //6.接回原来的链表
        pre.next = rigthNode;
        leftNode.next = cur;
        return dummyNode.next;
    }

    static Node reverseSubList(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return cur;
    }

    static Node reverseList2(Node head, int m, int n) {
        Node dummp = new Node(-1);
        dummp.next = head;
        Node pre = dummp;

        for (int i = 0; i < m - 1; i++) {
          pre = pre.next;
        }

        Node cur = pre.next;
        for (int i = m ; i < n ; i++) {
            Node t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }
        return dummp.next;
    }
}
