package com.yuan.algorithm.leedcode;

import java.util.*;

public class XiangQi {

    /**
     * 题目描述
     * 马是象棋（包括中国象棋和国际象棋）中的棋子，走法是每步直一格再斜一格，即先横着或者直者走一格，然后再斜着走一个对角线，可进可退，可越过河界，俗称"马走日"字。
     * <p>
     * 给定 m 行 n 列的棋盘（网格图），棋盘上只有棋子象棋中的棋子“马”，并且每个棋子有等级之分，等级为 k 的马可以跳 1~k 步（走的方式与象棋中“马”的规则一样，不可以超出棋盘位置），问是否能将所有马跳到同一位置，如果存在，输出最少需要的总步数（每匹马的步数相加），不存在则输出-1。
     * <p>
     * 注：允许不同的马在跳的过程中跳到同一位置，坐标为（x,y）的马跳一次可以跳到的坐标为：(x+1, y+2)，(x+1, y-2)，(x+2, y+1)，(x+2, y-1)，(x-1, y+2)，(x-1, y-2)，(x-2, y+1)，(x-2, y-1)，的格点上，但是不可以超出棋盘范围。
     * <p>
     * 输入描述
     * 第一行输入m，n，代表 m 行 n 列的网格图棋盘（1 ≤ m, n ≤ 25）
     * <p>
     * 接下来输入 m 行 n 列的网格图棋盘，如果第 i 行，第 j 列的元素为 "." ，代表此格点没有棋子，如果为数字 k（1 ≤ k ≤ 9），代表此格点存在等级为 k 的“马”
     * <p>
     * 输出描述
     * 输出最少需要的总步数（每匹马的步数相加），不存在则输出-1。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();  // Consume the remaining newline

        String[] g = new String[n];
        List<Knight> ma = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g[i] = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (g[i].charAt(j) != '.') {
                    ma.add(new Knight(i, j, Character.getNumericValue(g[i].charAt(j))));
                }
            }
        }

        int[][] dir = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        int[][] res = new int[n][m];

        for (Knight houre : ma) {
            int[][] dis = new int[n][m];
            for (int[] row : dis) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            dis[houre.x][houre.y] = 0;

            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{houre.x, houre.y});

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int x = current[0], y = current[1];

                for (int[] d : dir) {
                    int dx = x + d[0], dy = y + d[1];
                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                    if (dis[dx][dy] != Integer.MAX_VALUE) continue;

                    dis[dx][dy] = dis[x][y] + 1;
                    q.add(new int[]{dx, dy});
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dis[i][j] == Integer.MAX_VALUE) continue;
                    if (dis[i][j] > houre.moves) {
                        dis[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dis[i][j] != Integer.MAX_VALUE) {
                        res[i][j] += dis[i][j];
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.min(ans, res[i][j]);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static class Knight {
        int x, y, moves;

        Knight(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

}
