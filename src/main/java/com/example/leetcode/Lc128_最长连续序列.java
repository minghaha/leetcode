package com.example.leetcode;

import java.util.Arrays;

/**
 * @description: 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * @author: licm
 * @create: 2021-06-24 14:33
 **/
public class Lc128_最长连续序列 {
    /**
     * o (n)
     *
     * 需要注意的是 排序后 比较前后的数字，相同跳过，相同也算连续的，
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int count = 1;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0) {
                continue;
            } else if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                res = Math.max(count, res);
                count = 1;
            }
        }
        return Math.max(count, res);
    }

    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
