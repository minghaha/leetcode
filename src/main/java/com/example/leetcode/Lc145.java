package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 */
public class Lc145 {


    //递归
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5,6,7};
        TreeNode root = CreateNode.createTree(arr).get(0);
        List<Integer> list = postorderTraversal(root);
        list.forEach(n -> System.out.println(n));
    }
}
