package com.yuan.algorithm.bingChaJi;

import java.util.Scanner;

public class Mytest {

    /**
     * 并查集
     * 主要功能
     * 1、查询两个集合是否是同一个集合
     * 2、合并两个结合
     * 3、计算多个集合经过计算和可以合并为多少个结合
     * 结构： 一颗树形结构 合并集合的时候可以做到时间复杂度为O(1);合并逻辑  直接将一个集合的代表节点指向另一集合的代表节点
     * eg: 有一个集合是这样的： e指向d d指向c c指向b b指向a a指向自己 那么这个集合的代表节点就是a；
     * 如果两个元素一直向上找 找到的代表节点元素相同 那么这两个元素就是一个集合
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findCircle(arr));
    }

    private static int findCircle(int[][] m) {
        int n = m.length;
        UninfoFind uninfoFind = new UninfoFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (m[i][j] ==1) {
                    uninfoFind.union(i,j);
                }
            }
        }
        return uninfoFind.sets;
    }

    static class UninfoFind {
        // 直系父节点
        private int[] parents;

        // 每个集合的大小
        private int[] size;

        // 辅助数组 压缩路径时候使用
        private int[] help;

        // 集合个数
        private int sets;

        public UninfoFind(int n) {
            parents = new int[n];
            size = new int[n];
            help = new int[n];
            sets = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        private int find(int i) {
            int hi = 0;
            while (i != parents[i]) {
                help[hi++] = i;
                i = parents[i];
            }
            for (hi--; hi > 0; hi--) {
              parents[help[hi]] =i;
            }
            return i;
        }

        private void union(int i,int j){
            int f1 = find(i);
            int f2 = find(j);
            if(f2 != f1){
                if(size[f1] > size[f2]){
                    size[f1] += size[f2];
                    parents[f2] = f1;
                }else {
                    size[f2] += size[f1];
                    parents[f1] = f2;
                }
                sets--;
            }
        }

    }
    public int sets(){
        return this.sets();
    }
}
