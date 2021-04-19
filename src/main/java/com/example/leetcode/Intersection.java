package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
    /**
     * 通过hash表实现，因为没有限制大小 所以用集合
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();


        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }


        int resArray[] = new int[res.size()];
        int j = 0;
        for (Integer r : res) {
            resArray[j++] = r.intValue();
        }

        return resArray;
    }

    public static void main(String[] args) {
        int [] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        intersection(nums1,nums2);
    }
}
