package com.example.leetcode;

/**
 * @description: 1049. 最后一块石头的重量 II
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * @author: licm
 * @create: 2021-06-01 09:44
 **/
public class Lc1049_最后一块石头的重量II {
    /**
     * 1.确定dp含义 下标对应重量
     * 2.递推公式 max(dp[j],dp[j-stones[i]]+stones[i])
     * 3.初始化   用递推公式初始化
     * 4.遍历顺序  从左往右
     * 5.推导结果。。。
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        /**
         * 初始化容量 要么 30*1000/2+1
         *或者 sum/2+1
         */
        int[]dp = new int[sum/2+1];
        int target = sum/2;
        for (int i = 0; i <stones.length ; i++) {
            for (int j = target; j >=stones[i] ; j--) {
                /**
                 * 找每一堆最大重量
                 * 不是很懂，刷懂了再说，大概一次就是计算该堆最大重量的一种公式
                 */
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        /**
         * 这个某一个堆最大重量，一共俩堆
         */
        return  sum-dp[target]-dp[target];
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));;
    }
}
