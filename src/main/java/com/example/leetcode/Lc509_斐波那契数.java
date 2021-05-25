package com.example.leetcode;

/**
 * @description: 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 * @author: licm
 * @create: 2021-05-25 14:36
 **/
public class Lc509_斐波那契数 {

    /**
     * 对于动态规划问题，我将拆解为如下五步曲，这五步都搞清楚了，才能说把动态规划真的掌握了！
     *
     * 确定dp数组（dp table）以及下标的含义
     * 确定递推公式
     * dp数组如何初始化
     * 确定遍历顺序
     * 举例推导dp数组
     */

    /**
     * 1. 确定dp数组以及下标的含义 dp[i]代表第i个数值对应的结果dp[i]
     * 2. 确定递推公式（状态转移方程） dp[i]=dp[i-1]+dp[i-2]
     * 3. dp数组如何初始化 dp[0] = 0  dp[1] = 1
     * 4. 确定遍历顺序 从前到后
     * 5. 举例推到dp数组 0 1 1 2
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n<2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]= dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n =0;
        System.out.println(fib(n));
    }

}
