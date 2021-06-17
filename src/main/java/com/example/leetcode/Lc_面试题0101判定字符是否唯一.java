package com.example.leetcode;

/**
 * @description: 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * @author: licm
 * @create: 2021-06-17 09:46
 **/
public class Lc_面试题0101判定字符是否唯一 {
    /**
     *  位运算
     *  mark = 0
     *  mark & 1<<astr - 'a' ==0
     *  markl|= 1<<astr - 'a'
     *
     * 假定只有小写字母
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        int mark = 0;
        for (int i = 0; i < astr.length(); i++) {
            int c = astr.charAt(i)-'a';

            if((mark & 1<<c) != 0){
                return false;
            }
            mark |= 1<<c;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "leetcode";
//        String s = "abc";
        String s = "aa";
        System.out.println(isUnique(s));
    }
}
