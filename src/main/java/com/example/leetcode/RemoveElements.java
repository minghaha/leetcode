package com.example.leetcode;

public class RemoveElements {

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
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0,head);
        ListNode prev = sentinel,curr = head;
        while(curr!=null){
            if(curr.val==val){
                prev.next = curr.next;
            }else{
                prev =curr;
            }
            curr=curr.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(2,l4);
        ListNode l2 = new ListNode(4,l3);
        ListNode l1 = new ListNode(1,l2);
        int val =1;
        removeElements(l1,val);
    }

}
