package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * <p>
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class Lc226 {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.right = right;
        root.left = left;
        return root;
    }

    static List<Integer> res = new ArrayList<>();
    public static List<Integer> preOrder(TreeNode root){
        if(root != null){
            res.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
        return res;
    }
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = CreateNode.createTree(arr).get(0);
        invertTree(root);
        preOrder(root).forEach(n->{
            System.out.println(n);
        });

    }


}
