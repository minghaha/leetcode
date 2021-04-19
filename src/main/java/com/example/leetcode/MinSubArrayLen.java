package com.example.leetcode;

public class MinSubArrayLen {
    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int resultLength = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                int len = end - start + 1;
                resultLength = resultLength < len ? resultLength : len;
                sum -= nums[start++];
            }
        }
        if (resultLength == Integer.MAX_VALUE) {
            return 0;
        } else {

            return resultLength;
        }
    }
}
