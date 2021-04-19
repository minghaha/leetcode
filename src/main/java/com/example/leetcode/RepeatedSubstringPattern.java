package com.example.leetcode;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * 通过次数61,782提交次数120,991
 */
public class RepeatedSubstringPattern {
    /**
     * kmp
     * 找最大相等前后缀 和原串对比
     * 如果当前模式串对应最大相等前缀为 0 既 next[len-1] = 0,则不能
     * 如果。。。。。。。。。。。。。。x，x能被 len-1取余为0 则能
     * 如果。。。。。。。。。。。。。。x,x =  len-1则能
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        next = getNext(next, s);
//        System.out.println("=============next=================");
//        for (int i = 0; i < next.length; i++) {
//            System.out.print(next[i] + " ");
//        }
//        System.out.println();
//        System.out.println("===============next=====================");

        int len = s.length();
        if (next[next.length - 1] != 0 && len % (len - (next[len - 1])) == 0) {
            return true;
        }
        return false;
    }

    /**
     * 找最大公共前后缀
     *
     * @return
     */
    private static int[] getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                /**
                 * 注意用自己本身去往前挪动
                 */
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abac"));
    }
}
