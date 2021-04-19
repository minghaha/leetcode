package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
 */
public class Lc94 {


    //递归
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {

            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        TreeNode root = CreateNode.createTree(arr).get(0);
        List<Integer> list = inorderTraversal(root);
        list.forEach(n -> System.out.println(n));
    }
}
