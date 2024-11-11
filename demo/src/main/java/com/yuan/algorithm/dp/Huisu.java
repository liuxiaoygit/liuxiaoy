package com.yuan.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Huisu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int m = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(arr, m));
    }

    public static int getResult(Integer[] arr, int m) {
        Integer[] newArr = Arrays.stream(arr).filter(val -> val <= m).toArray(Integer[]::new);
        int min = newArr[0];

        return dfs(newArr, 0, 0, min, m, 0);
    }

    public static int dfs(Integer[] arr, int index, int sum, int min, int m, int count) {
        if (sum > m) {
            return count;
        }

        if (sum == m || (m - sum < min && m - sum > 0)) {
            return count + 1;
        }

        for (int i = index; i < arr.length; i++) {
            count = dfs(arr, i, sum + arr[i], min, m, count);
        }

        return count;
    }
}
