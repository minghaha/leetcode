package com.example.leetcode;

public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] res = generateMatrix(4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //开始位置
        int startX = 0, startY = 0;
        //循环次数
        int loop = n / 2;
        //如果循环次数是奇数，那么会存在中心点，中心点是最后赋值,中心点位置
        int mid = n / 2;
        //每条边边界,每循环一圈就加2，因为进内圈需要加1，同时边界向内收缩1
        int offset = 1;
        //初始赋值
        int count = 1;
        //原则 左闭又开
        // 上面 从左右导游
        // 右边 从上到下
        // 下面 从右到在
        // 左边 从下到上
        while ((loop--) > 0) {
            int i = startX;
            int j = startY;

            // 上面 从左右导游
            for (; j < startY + n - offset; j++) {
                res[startX][j] = count++;
            }

            // 右边 从上到下
            for (; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }

            // 下面 从右到在
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 左边 从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            startX++;
            startY++;
            offset += 2;

        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
