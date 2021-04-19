package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc222_完全二叉树的节点个数 {
    /**
     * 思路；dfs,统计集合大小即可
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res.size();
    }

    void traversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        traversal(root.left,res);
        traversal(root.right,res);
    }
}
