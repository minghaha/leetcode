package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 */
public class Lc144 {
    //循环
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> list = new ArrayList<>();
//        TreeNode curr = root;
//        while (curr!=null || !stack.isEmpty()){
//            while(curr!=null){
//                list.add(curr.val);
//                stack.push(curr);
//                curr=curr.left;
//            }
//            curr = stack.pop();
//            curr =curr.right;
//        }
//        return list;
//    }

    //递归
    static List<Integer> list = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root){
        if(root!=null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1,2,3,4,5,6,7};
        TreeNode root = CreateNode.createTree(arr).get(0);
        List<Integer> list = preorderTraversal(root);
        list.forEach(n -> System.out.println(n));
    }
}
