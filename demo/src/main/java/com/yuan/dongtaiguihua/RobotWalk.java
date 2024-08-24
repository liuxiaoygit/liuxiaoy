package com.yuan.dongtaiguihua;

public class RobotWalk {


    /**
     * 题目
     * 假设有排成一行的N个位置 记为 1~N，N一定大于2
     * 开始是机器人在 M位置
     * 如果机器人来到1位置那么下一步只能到2位置
     * 如果机器人来到N位置下一步只能到N-1位置
     * 如果机器人在中间位置 那么可以左右走
     * 规定机器人必须走K步 最终要来到P位置
     * 问 有多少中走法
     */

    public static void main(String[] args) {
        int n = 5;
        int k = 6;
        int p = 4;
        int m = 2;
        System.out.println(ways1(2, 6, 4, 5));
        System.out.println(ways2(2, 6, 4, 5));
        System.out.println(ways3(2, 6, 4, 5));
    }


    public static int ways1(int cur, int rest, int aim, int n) {
        return process1(cur, rest, aim, n);
    }

    public static int ways2(int cur, int rest, int aim, int n) {
        int[][] dp = new int[n + 1][rest + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= rest; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(cur, rest, aim, n, dp);
    }

    public static int ways3(int start, int k, int aim, int n) {
        int[][] dp = new int[n + 1][k + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            dp[1][rest] = dp[2][rest-1];
            for (int cur = 2; cur < n; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[n][rest] = dp[n - 1][rest - 1];
        }

        return dp[start][k];
    }


    public static int process1(int cur, int rest, int aim, int n) {
        //可走步数走完了 如果到了目标位置那么就是一种方法
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }

        if (cur == 1) {
            return process1(2, rest - 1, aim, n);
        }

        if (cur == n) {
            return process1(n - 1, rest - 1, aim, n);
        }
        return process1(cur - 1, rest - 1, aim, n) + process1(cur + 1, rest - 1, aim, n);
    }

    public static int process2(int cur, int rest, int aim, int n, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int res = 0;
        if (rest == 0) {
            res = cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            res = process1(2, rest - 1, aim, n);
        }
        if (cur == n) {
            res = process1(n - 1, rest - 1, aim, n);
        }
        res = process1(cur - 1, rest - 1, aim, n) + process1(cur + 1, rest - 1, aim, n);
        dp[cur][rest] = res;
        return res;

    }


}
