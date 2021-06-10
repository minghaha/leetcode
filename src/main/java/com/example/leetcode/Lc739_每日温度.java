package com.example.leetcode;

import java.util.Stack;

/**
 * @description: 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * @author: licm
 * @create: 2021-06-10 15:56
 **/
public class Lc739_每日温度 {
    /**
     * 单调栈，栈内顺序要么从大到小 要么从小到大,本题从大到笑
     * <p>
     * 入站元素要和当前栈内栈首元素进行比较
     * 若大于栈首则 则与元素下标做差
     * 若大于等于则放入
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            /**
             * 取出下标进行元素值的比较
             */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            /**
             * 注意 放入的是元素位置
             */
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(t);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }
}
