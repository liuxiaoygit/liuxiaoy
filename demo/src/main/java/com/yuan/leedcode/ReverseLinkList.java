package com.yuan.leedcode;

import com.alibaba.fastjson.JSON;

/**
 * 翻转列表
 */
public class ReverseLinkList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        reverse(node1);
        System.out.println(node1);
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, cure, next;
        cure = head;
        while (cure != null){
             next = cure.next;
             cure.next = prev;
             prev = cure;
             cure = next;

        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
