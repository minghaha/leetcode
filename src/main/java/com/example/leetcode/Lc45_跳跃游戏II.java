package com.example.leetcode;

/**
 * @description: 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [2,3,0,1,4]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 * @author: licm
 * @create: 2021-05-18 09:54
 **/
public class Lc45_跳跃游戏II {
    /**
     * 因为总能达到最后一个位置，所以每次跳都跳到范围呢 最大的那个数字上
     */
    public static int jump(int[] nums) {

        /**
         * 记录跳跃次数
         */
        int count = 0;
        /**
         * 记录跳跃开始位置
         */
        int start = 0;
        /**
         * 记录跳跃结束位置，注意结束位置初始化的值是1
         */
        int end = 1;
        for ( ;end<nums.length; ) {
            int cover = 0;
            /**
             * 注意end,不能到达end,只能到达end-1
             */
            for (int j = start; j < end; j++) {
                cover = Math.max(cover,j+nums[j]);
            }
            /**
             * 注意 end+1
             */
            start = end;
            end = cover+1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
//        int[] nums = {0};
        System.out.println(jump(nums));
    }
}
