package com.example.leetcode;

import java.util.*;

/**
 * @description: 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * @author: licm
 * @create: 2021-04-27 09:57
 **/
public class Lc40_组合总和II {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, path, res, used);
        return res;
    }

    static void backtracking(int[] candidates, int target, int sum, int startIndex, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        /**
         * 递归终止条件
         */
        if (sum > target) {
            return;
        }

        /**
         * 递归返回
         */
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        /**
         * 因为没有数量限制，所以要遍历自己，那么startIndex 就不用加1啦
         * - used[i - 1] == true，说明同一树支candidates[i - 1]使用过
         * - used[i - 1] == false，说明同一树层candidates[i - 1]使用过
         */
        for (int i = startIndex; i < candidates.length; i++) {
            /**
             * 同层级的重复是不允许的
             */
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            sum += candidates[i];
            path.addLast(candidates[i]);
            used[i] = true;
            backtracking(candidates, target, sum, i + 1, path, res, used);
            //回溯
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        res.forEach(m -> {
            for (Integer r : m) {
                System.out.print(r + "");
            }
            System.out.println();
        });
        System.out.println();
    }
}
