package com.example.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TopKFrequent {
    /**
     * 本题考点就是优先队列中大顶堆和小顶堆的使用
     * 堆是一种完全二叉树结构，优先队列可以通过内部排序维持内部顺序
     * 前topk 大小和队列大小顶堆反着用，这样省空间
     * <p>
     * 引用
     * topk （前k大）用小根堆，维护堆大小不超过 k 即可。每次压入堆前和堆顶元素比较，如果比堆顶元素还小，直接扔掉，否则压入堆。检查堆大小是否超过 k，如果超过，弹出堆顶。复杂度是 nlogk
     * 避免使用大根堆，因为你得把所有元素压入堆，复杂度是 nlogn，而且还浪费内存。如果是海量元素，那就挂了。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        /**
         使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值\
         *
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        /**
         *
         遍历map，用最小堆保存频率最大的k个元素
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map.get(o1) - map.get(o2);
                    }
                }
        );

        // 取出最小堆中的元素
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.poll();
                priorityQueue.add(key);
            }
        }

        int[] resArray = new int[priorityQueue.size()];
        for (int i = 0; !priorityQueue.isEmpty(); i++) {
            resArray[i] = priorityQueue.poll();
        }
        return resArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3};
        int k = 3;
        int[] res = topKFrequent(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
