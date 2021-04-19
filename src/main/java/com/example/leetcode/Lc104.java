package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Lc104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            List<String> res = new ArrayList<>();
            traverse(root, "", res);
            int maxLen = 0;
            for (String re : res) {
                int strLen = re.split("->").length;
                maxLen = maxLen < strLen ? strLen : maxLen;
            }
            return maxLen;
        }
    }

    static void traverse(TreeNode root, String path, List<String> res) {
        path += root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
        } else {
            path += "->";
            traverse(root.left, path, res);
            traverse(root.right, path, res);
        }
    }


    public static void main(String[] args) {

        Integer[] arr = new Integer[]{3, 9, 20, 15, 7, null, null};
        TreeNode root = CreateNode.createTree(arr).get(0);
        System.out.println(maxDepth(root));
        ;

    }

}
