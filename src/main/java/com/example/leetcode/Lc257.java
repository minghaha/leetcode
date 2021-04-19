package com.example.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
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
 */
public class Lc257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        construct_paths(root,"",paths);
        return paths;
    }

    public static void construct_paths(TreeNode root, String path, LinkedList<String> paths){
        if(root!=null){
            path += root.val;
            //若无左右子节点则为叶子节点
            if(root.left==null && root.right==null){
                paths.add(path);
            }else{
                //每一个根节点都有可能俩个子节点
                path+="->";
                construct_paths(root.left,path,paths);
                construct_paths(root.right,path,paths);
            }
        }
    }
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = CreateNode.createTree(arr).get(0);
        binaryTreePaths(root).forEach(n->{
            System.out.println(n);
        });

    }
}
