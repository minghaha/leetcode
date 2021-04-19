package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们在进行二分查找查找数据的时候，如果有两个重复值，就会出现找到了第二个值的下标
 * 并不能将两个相同元素的下标都找出来。
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 6,6, 6, 7, 8, 9};
        List<Integer> index = binarySearch(arr, 6);
        boolean empty = index.isEmpty();
        System.out.println(empty ? "不好意思,没有找到要进行检索的元素" : "您找到的元素下标为:" + index + "");
    }

    /**
     * 改进后的二分查找
     */
    public static List<Integer> binarySearch(int[] arr, int val) {
        List<Integer> indexList = new ArrayList<>();//用于接收返回的元素下标

        //数组的开始以及结束下标
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (arr[mid] < val)
                begin = mid + 1;
            else if (arr[mid] > val)
                end = mid - 1;
            else {    //表示arr[mid] == val
                /*思路分析
                1.在找到mid索引值，不要马上返回
                2.向mid索引值的左边扫描,将所有满足1000，的元素的下标， 加入到集合ArrayList
                3.向mid索引值的右边扫描，将所有满足1000， 的元素的下标，加入到集合ArrayList
                4.将ArrayList返回*/

                //向mid左边扫描
                int temp = mid - 1;
                while (true) {
                    if (temp < 0 || arr[temp] != val)//没有找到就退出循环
                        break;
                    //执行到这里说明找到了,就把找到的元素添加到集合中,继续向左找
                    indexList.add(temp);
                    temp -= 1;
                }
                indexList.add(mid);//加入已经找到了的元素【arr[mid]==val】
                //向mid右边扫描
                temp = mid + 1;
                while (true) {
                    if (temp > arr.length - 1 || arr[temp] != val)
                        break;
                    //执行到这里说明找到了,就把找到的元素添加到集合中,继续向右
                    indexList.add(temp);
                    temp += 1;
                }
                return indexList;
            }
        }
        return indexList;
    }
}