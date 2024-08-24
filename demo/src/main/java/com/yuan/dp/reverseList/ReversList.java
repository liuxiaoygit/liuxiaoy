package com.yuan.dp.reverseList;

public class ReversList {

    public static void main(String[] args) {
        Node head = new Node(4);
        Node tail = head;
        for (int i = 0; i < 3; i++) {
            Node item = new Node(i);
            tail.setNext(item);
            tail = item;
        }
        Node node = reverseList(head);
        System.out.println(node.getVal());
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            cur.setNext(pre);
            if(next == null){
                break;
            }
            pre = cur;
            cur = next;

        }
        return cur;
    }
}
