package com.example.leetcode;

import java.util.LinkedList;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
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
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Lc112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        LinkedList<String> linkedList = new LinkedList<>();
        calc(root,0,"",linkedList,sum);
//        linkedList.forEach(n->{
//            System.out.println(n);
//        });
        return !linkedList.isEmpty();
    }
    public static void calc(TreeNode root, int res , String path ,LinkedList<String> paths,int sum){
        if(root!=null){
            path+=root.val;
            res+=root.val;
            if(root.left==null && root.right==null&&res==sum){
//                System.out.println(path);
//                System.out.println(res);
                paths.add(path);
            }else{
                path += "->";
                calc(root.left,res,path,paths,sum);
                calc(root.right,res,path,paths,sum);
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = CreateNode.createTree(arr).get(0);

        System.out.println( hasPathSum(root,7));

    }

}
