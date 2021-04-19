package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CreateNode {
    public static List<TreeNode> list = new ArrayList<TreeNode>(); // 用一个集合来存放每一个Node

    public static List<TreeNode> createTree(Integer[] array) {
        list.clear();
        for (int i = 0; i < array.length; i++) {
            TreeNode TreeNode = new TreeNode(array[i], null, null); // 创建结点，每一个结点的左结点和右结点为null
            list.add(TreeNode); // list中存着每一个结点
        }
        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) { // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
        return list;
    }

    // 遍历，先序遍历
    public static void print(TreeNode TreeNode) {
        if (TreeNode != null) {
            System.out.print(TreeNode.val + " ");
            print(TreeNode.left);
            print(TreeNode.right);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 2, null, 3, null, 3 };
        CreateNode.createTree(array);
        print(list.get(0));
    }
}


