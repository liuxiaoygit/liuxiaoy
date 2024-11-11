package com.yuan.algorithm.dongtaiguihua;

/**
 *  动态规划分析步骤 1、暴力递归尝试 2、优化递归增加缓存 3、从顶向下的递归 记忆化搜索
 */

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
public class JiQiRen {


    public static void main(String[] args) {
        System.out.println("ways1方法数" + ways1(2, 4, 4, 4));
    }

    /**
     * @param cur  当前位置
     * @param rest 剩余步
     * @param aim  目标位置
     * @param N    总位置数
     * @return
     */

    public static int ways1(int cur, int rest, int aim, int N) {
        return process1(cur, rest, aim, N);
    }

    private static int process1(int cur, int rest, int aim, int n) {
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


}
