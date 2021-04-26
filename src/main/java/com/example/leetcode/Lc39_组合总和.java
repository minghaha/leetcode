package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * @author: licm
 * @create: 2021-04-26 10:02
 **/
public class Lc39_组合总和 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, 0, 0, path, res);
        return res;
    }

   static  void backtracking(int[] candidates, int target, int sum, int startIndex, Deque<Integer> path, List<List<Integer>> res) {
       /**
        * 递归终止条件
        */
       if(sum>target){
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
        */
       for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.addLast(candidates[i]);
            backtracking(candidates, target, sum, i, path, res);
            //回溯
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        res.forEach(m -> {
            for (Integer r : m) {
                System.out.print(r + "");
            }
            System.out.println();
        });
        System.out.println();
    }
}
