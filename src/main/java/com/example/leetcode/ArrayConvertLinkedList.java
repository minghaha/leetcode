package com.example.leetcode;

import java.util.ArrayList;

public class ArrayConvertLinkedList {

        public static ListNode arrayToNode(int[] arr){
            ListNode head = new ListNode(arr[0]); // 把数组的第一个位置定义为头结点
            ListNode other = head; // 一个指针，此时指向头结点
            for(int i=1;i<arr.length;i++){ //头结点已经定义，从1开始
                ListNode temp = new ListNode(arr[i]);
                other.next = temp;
                other = other.next;

            }//在此处打印结点容易导致head的变化
            return head;
        }
        public static void printNode(ListNode listNode){
            while(listNode !=null){
                System.out.print(listNode.val+" ");
                listNode = listNode.next;
            }
        }
        public static void nodeTolist(ListNode listNode){
            ArrayList<Integer> list = new ArrayList<>();
            while(listNode != null){
                list.add(listNode.val);
                listNode = listNode.next;
            }
            System.out.println();
            System.out.println(list);
        }
        public static void main(String[] args){
            int[] arr = new int[]{1,2,3,4,5,6};
            ListNode listNode = arrayToNode(arr);
            printNode(listNode);
            nodeTolist(listNode);

        }

}
