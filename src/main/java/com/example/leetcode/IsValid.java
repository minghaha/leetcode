package com.example.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid {
    /**
     * 在栈中放入与之匹配的右半部分
     * 如果遇到右半部分就看与当前栈头是否一致
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(')');
            } else if (s.charAt(i) == '{') {
                st.push('}');
            } else if (s.charAt(i) == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.peek() != s.charAt(i)) {
                return false;
            } else {
                st.pop();
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
