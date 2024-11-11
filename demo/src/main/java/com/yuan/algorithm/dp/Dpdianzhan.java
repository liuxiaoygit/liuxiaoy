package com.yuan.algorithm.dp;

import java.util.Scanner;

public class Dpdianzhan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int s = sc.nextInt();
        int min = sc.nextInt();

        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(matrix, r, c, s, min));
    }

    /**
     * @param matrix 调研区域每单元面积的发电量矩阵
     * @param r      调研区域的长
     * @param c      调研区域的宽
     * @param s      正方形电站的边长
     * @param min    正方形电站的最低发电量
     * @return 调研区域内有几个符合要求的正方形发电站
     */
    public static int getResult(int[][] matrix, int r, int c, int s, int min) {
        // 压缩后的行数
        int zip_r = r - s + 1;
        // 压缩后的列数
        int zip_c = c - s + 1;

        // 先进行列压缩
        int[][] zip_col_dps = new int[r][zip_c];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < s; j++) {
                zip_col_dps[i][0] += row[i];
            }

            for (int j = 1; j < zip_c; j++) {
                zip_col_dps[i][j] = zip_col_dps[i][j - 1] - row[j - 1] + row[j + s - 1];
            }
        }

        // 更新矩阵
        matrix = zip_col_dps;

        int ans = 0;

        // 再进行行压缩
        int[][] zip_col_row_dps = new int[zip_r][zip_c];

        for (int j = 0; j < zip_c; j++) {
            for (int i = 0; i < s; i++) {
                zip_col_row_dps[0][j] += matrix[i][j];
            }
            // 压缩后的每一个区块都是一个边长为s的正方形，只要其发电量>=min即可
            if (zip_col_row_dps[0][j] >= min) ans++;

            for (int i = 1; i < zip_r; i++) {
                zip_col_row_dps[i][j] = zip_col_row_dps[i - 1][j] - matrix[i - 1][j] + matrix[i + s - 1][j];
                // 压缩后的每一个区块都是一个边长为s的正方形，只要其发电量>=min即可
                if (zip_col_row_dps[i][j] >= min) ans++;
            }
        }

        return ans;
    }

}
