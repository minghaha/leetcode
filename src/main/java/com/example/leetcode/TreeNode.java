package com.example.leetcode;

public class TreeNode {

    public Integer val; // 自己本身值
    public TreeNode left; // 左结点
    public TreeNode right; // 右结点

    public TreeNode() {
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}