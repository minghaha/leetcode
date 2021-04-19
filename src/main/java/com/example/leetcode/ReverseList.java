package com.example.leetcode;

public class ReverseList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

    /**
     * 206. 反转链表
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * @param head
     * @return
     */

    //迭代
    public static ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode pre = null, curr = head;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    //递归
    public static ListNode reverseList1(ListNode head) {
        return reverse(null, head);
    }

    private static ListNode reverse(ListNode pre, ListNode curr) {
        if (curr == null) {
            return pre;
        }
        ListNode temp = null;
        temp = curr.next;
        curr.next = pre;
        pre = curr;
        curr = temp;
        return reverse(pre, curr);
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        reverseList(l1);
//        reverseList1(l1);
    }
}
