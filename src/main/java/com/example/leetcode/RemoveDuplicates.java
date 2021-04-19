package com.example.leetcode;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class RemoveDuplicates {
    /**
     * 通过 栈对每一个元素匹配，
     * <p>
     * 简单来说 字符串与当前栈内字符进行匹配，如果相同就出栈当前元素，并且跳过当前元素，如果不匹配就入栈
     *
     * @param S
     * @return
     */
    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
                continue;
            } else {
                stack.push(S.charAt(i));
            }
        }

        StringBuilder str = new StringBuilder();
        for (Character c : stack) {
            str.append(c);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
