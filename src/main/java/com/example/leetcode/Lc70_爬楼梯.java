package com.example.leetcode;

/**
 * @description: s
 * @author: licm
 * @create: 2021-05-26 09:48
 **/
public class Lc70_爬楼梯 {
    /**
     * 1. 确定dp[i] 含义，代表每一个楼梯可以走到的几种方法
     * 2. 状态转移方程 fn = f(n-1)+f(n-2)
     * 3. 初始化 dp[0]=1  dp[1] = 2
     * 4. 确定遍历顺序 从左到又
     * 5. 列举答案
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n<2){
            return  n;
        }
        int[] dp = new int[n+1];
        dp[1]=1;dp[2]=2;
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
