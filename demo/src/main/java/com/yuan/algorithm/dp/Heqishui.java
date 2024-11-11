package com.yuan.algorithm.dp;

import java.util.Scanner;

public class Heqishui {
    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int sum = 0;
            if (a == 0) {
                break;
            }
            //dfs(sum, a);
            System.out.println(dfs(sum, a));
        }
    }

    private static int dfs(int sum, int a) {
        //System.out.println(a/3 + a%3);
        if (a > 0 && a / 3 > 0) {
            sum = sum + a / 3;
            int empty = a / 3 + a % 3;
            if (empty == 2) {
                empty = empty + 1;
            }
            return dfs(sum, empty);
        } else {
            return sum;
        }
    }

}
