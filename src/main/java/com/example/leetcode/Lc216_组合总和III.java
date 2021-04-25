package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * @author: licm
 * @create: 2021-04-25 17:13
 **/
public class Lc216_组合总和III {
    /**
     * 跟77组合很相似，也是遍历所有，但是会涉及到回查问题
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(k, n, 1, 0, path, res);
        return res;

    }

    static void backtracking(int k, int n, int startIndex, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            //处理
            sum += i;
            path.addLast(i);
            backtracking(k, n, i + 1, sum, path, res);
            //回溯
            sum -= i;
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 7);
        res.forEach(m -> {
            for (Integer r : m) {
                System.out.print(r + "");
            }
            System.out.println();
        });
        System.out.println();
    }
}
