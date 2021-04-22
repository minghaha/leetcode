package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @author: licm
 * @create: 2021-04-22 10:41
 **/
public class Lc77_组合 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtracking(n, k, 1, res, path);
        return res;
    }

    static void backtracking(int n, int k, int startIndex, List<List<Integer>> res, Deque<Integer> path) {
        /**
         * 回溯终止条件
         * 数组长度等于k
         */
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        /**
         * 回溯过程
         * 包括n
         */
        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            /**
             * startIndex 每次递归都用 i 既当前的值去加一
             */
            backtracking(n, k, i + 1, res, path);
            /**
             * 又回头操作的 回头之前做了啥 回头之后就做逆反操作
             */
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>>  res =    combine(4,2);
        res.forEach(m->{
            for (Integer r : m){
                System.out.print(r + "");
            }
            System.out.println();
        });
        System.out.println();
    }
}
