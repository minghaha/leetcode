package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Lc113 {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<String> linkedList = new LinkedList<>();
        calc(root, 0, "", linkedList, sum);
        linkedList.forEach(n->{
            System.out.println(n);
        });
        List<List<Integer>> lists = new ArrayList<>();
        linkedList.forEach(n->{
            String[] temp = n.split(",");
            List<Integer> temps =new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {
                temps.add(Integer.valueOf(temp[i]));
            }
            lists.add(temps);
        });

        return lists;
    }

    public static void calc(TreeNode root, int res, String path, LinkedList<String> paths, int sum) {
        if (root != null) {
            path += root.val;
            res += root.val;
            if (root.left == null && root.right == null && res == sum) {
//                System.out.println(path);
//                System.out.println(res);
                paths.add(path);
            } else {
                path += ",";
                calc(root.left, res, path, paths, sum);
                calc(root.right, res, path, paths, sum);
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = CreateNode.createTree(arr).get(0);
        pathSum(root, 7).forEach(n->{
           n.forEach(m->{
               System.out.println(m);
           });
        });
    }

}
