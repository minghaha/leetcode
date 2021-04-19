package com.example.leetcode;

import java.util.Stack;

public class Lc206 {
    //反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = head;
        while(curr!=null){
            stack.push(curr);
            curr = curr.next;
        }
        ListNode revert = new ListNode();
        ListNode temp = revert;
        while(stack!=null && !stack.isEmpty()){
            revert.next = stack.pop();
        }
        return temp.next;
    }

}
