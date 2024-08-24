package com.yuan.bingChaJi;

import org.apache.axis.types.UnsignedInt;

import java.util.Scanner;

/**
 * 4
 * 1 1 0 0
 * 1 1 1 0
 * 0 1 1 0
 * 0 0 0 1
 */

public class BingChaJi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();


        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //System.out.println(xiaoxiaoLe(arr, x, y));

        System.out.println(findCircleNum(arr));
    }

    private static int xiaoxiaoLe(Integer[][] arr, int x, int y) {
        int result = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == 1) {
                    result++;
                    pollute(arr, x, y, i, j);
                }
            }
        }

        return result;
    }

    private static void pollute(Integer[][] arr, int x, int y, int i, int j) {
        System.out.println("x" + x + "y:" + y + "i:" + i + "j" + j);
        if (i < 0 || i >= x || j < 0 || j >= y || arr[i][j] != 1) {
            return;
        }
        arr[i][j] = 2;
        pollute(arr, x, y, i, j - 1);
        pollute(arr, x, y, i + 1, j);
        pollute(arr, x, y, i, j + 1);
        pollute(arr, x, y, i + 1, j);
    }

    /**
     * 找亲亲 或者版本集实现
     *
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int N = M.length;
        // {0} {1} {2} {N-1}
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) { // i和j互相认识
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets();
    }

    public static class UnionFind {
        // parent[i] = k ： i的父亲是k
        private int[] parent;
        // size[i] = k ： 如果i是代表节点，size[i]才有意义，否则无意义
        // i所在的集合大小是多少
        private int[] size;
        // 辅助结构
        private int[] help;
        // 一共有多少个集合
        private int sets;

        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            help = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 从i开始一直往上，往上到不能再往上，代表节点，返回
        // 这个过程要做路径压缩
        private int find(int i) {
            int hi = 0;
            while (i != parent[i]) {
                help[hi++] = i;
                i = parent[i];
            }
            for (hi--; hi >= 0; hi--) {
                parent[help[hi]] = i;
            }
            return i;
        }

        public void union(int i, int j) {
            int f1 = find(i);
            int f2 = find(j);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }
        }

        public int sets() {
            return sets;
        }
    }

}
