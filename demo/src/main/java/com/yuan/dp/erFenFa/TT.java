package com.yuan.dp.erfen;

import java.util.Arrays;
import java.util.Scanner;

public class TT {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(getResult(n, positions, m));
    }

    private static int getResult(int n, int[] positions, int m) {
        Arrays.sort(positions);
        int min = 1;
        int max = positions[n - 1] - positions[0];
        int ans = 0;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (check(positions, m, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }

    private static boolean check(int[] positions, int m, int mid) {
        int count = 1;

        int curpos = positions[0];
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - curpos >= mid) {
                count++;
                curpos = positions[i];
            }
        }
        return count >= m;
    }

}
