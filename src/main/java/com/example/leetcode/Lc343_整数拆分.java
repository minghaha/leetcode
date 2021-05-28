package com.example.leetcode;

/**
 * @description: 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * @author: licm
 * @create: 2021-05-28 14:47
 **/
public class Lc343_整数拆分 {
    /**
     * 1.确定dp下标含义 i对应的最大乘积
     * 2.确定递推公式 max(dp[i],max((i-j)*j,dp[i-j]))
     * 3.初始化 dp[2]=1
     * 4.确定遍历顺序从前往后遍历
     * 5.推导结果。。。
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

}


