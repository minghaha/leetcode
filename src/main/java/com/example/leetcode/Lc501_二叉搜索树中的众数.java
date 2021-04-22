package com.example.leetcode;

import java.util.*;

/**
 * @description: 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * @author: licm
 * @create: 2021-04-21 15:40
 **/
public class Lc501_二叉搜索树中的众数 {
    /**
     * 思路 ： 普通的递归遍历 map记录结果集，最后根据结果集进行筛选
     * @param root
     * @return
     */
    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        travesal(root, map);

        List<Integer> temps = new ArrayList<>();

        int max = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            max = max>=m.getValue()?max:m.getValue();
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            String key = m.getKey().toString();
            if (Integer.valueOf(m.getValue().toString()) == max) {
                temps.add(m.getKey());
            }
        }

        int[] res = new int[temps.size()];
        for (int i = 0; i < temps.size(); i++) {
            res[i] = temps.get(i);
        }
        return res;
    }

    static void travesal(TreeNode root, Map<Integer, Integer> res) {
        if (root == null) {
            return;
        }
        if (res.containsKey(root.val)) {
            res.put(root.val, res.get(root.val) + 1);
        } else {
            res.put(root.val, 1);
        }
        travesal(root.left, res);
        travesal(root.right, res);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0,1};
        TreeNode root = CreateNode.createTree(arr).get(0);
        int[] res = findMode(root);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
