package com.example.leetcode;

/**
 * @description:
 * @author: licm
 * @create: 2021-06-23 09:44
 **/
public class Lc_剑指Offer15二进制中1的个数 {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        /**
         * 标准位运算题目
         * 1&1 = 1
         * 0&1 = 0
         * 无符号右移 >>>
         */
        int res = 0;
        while(n!=0){
            res+=n&1;
            n=n>>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
}
