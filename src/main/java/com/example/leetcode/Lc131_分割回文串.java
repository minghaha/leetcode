package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * @author: licm
 * @create: 2021-05-06 16:05
 **/
public class Lc131_分割回文串 {

    /**
     * 判断是否是回文数
     *
     * TODO 虽然不理解为什么用了字符数组可以，字符串截取就不行，但ac啦下次再看
     * @param s
     * @param begin
     * @param end
     * @return
     */
    static boolean isPalindrom(char[]  s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        backtracking(s.toCharArray(), 0, res, path);
        return res;
    }

    static void backtracking(char[] s, int startIndex, List<List<String>> res, Deque<String> path) {
        if (startIndex == s.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length; i++) {
            if (isPalindrom(s, startIndex, i)) {
                path.addLast(new String(s,startIndex, i - startIndex + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1, res, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        res.forEach(m -> {
            for (String r : m) {
                System.out.print(r + "");
            }
            System.out.println();
        });
        System.out.println();
    }
}
