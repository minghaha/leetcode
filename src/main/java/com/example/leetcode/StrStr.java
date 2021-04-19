package com.example.leetcode;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {

    /**
     * kmp算法
     * 构建next前缀数组，存储匹配个数的数组
     * 步骤
     * 初始化
     * 处理前缀不相同情况
     * 处理前缀相同情况
     * 注意的是在处理前后缀不相同时 j要想后走，如果是第一位就不走了
     * 处理前后缀相同的时候j先加一，然后把 j的值 赋给next[i]
     *
     * @param haystack
     * @param needle
     * @return
     */
    private static int[] getNext(int[] next, String needle) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }

            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * 这里是直接用next 不进行任何操作
     * @param haystack 文本串
     * @param needle   模式串
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        int[] next = new int[needle.length()];
        next = getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "abaaba";
        String str2 = "abaf";
        System.out.println(strStr(str1, str2));
    }
}
