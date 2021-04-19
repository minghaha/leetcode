package com.example.leetcode;

/**
 * 35. 搜索插入位置
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
 输出: 2
 示例 2:

 输入: [1,3,5,6], 2
 输出: 1
 示例 3:

 输入: [1,3,5,6], 7
 输出: 4
 示例 4:

 输入: [1,3,5,6], 0
 输出: 0
 */
public class SearchInsert {
    /**
     * 二分法 首先确定不变量，既不变区间【0，nums.length -1】,左闭右闭区间
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int middle  = left + ((right -left)/2);
            if(nums[middle]<target){
                left = middle + 1;
            }else if(nums[middle]>target){
                right = middle -1;
            }else{
                return middle;
            }
        }
        return right+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 6,6, 6, 7, 8, 9};
        int target = 6;
        System.out.println(searchInsert(arr,target));
    }
}
