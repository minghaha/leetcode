package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @author: licm
 * @create: 2021-04-19 20:35
 **/
public class Lc257_二叉树的所有路径 {
    /**
     * 思路：dfs,记录所有路径，直到到最后一个节点
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        traversal(root, "", paths);
        return paths;
    }

    static void traversal(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
        }
        path += "->";
        traversal(root.left, path, paths);
        traversal(root.right, path, paths);
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = CreateNode.createTree(arr).get(0);
        binaryTreePaths(root).forEach(n -> {
            System.out.println(n);
        });

    }

}
