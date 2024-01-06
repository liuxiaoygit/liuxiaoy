package com.example.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TanXin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = Integer.parseInt(sc.nextLine());
        Integer[] f =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] s =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(m, f, s));
    }

    public static int getResult(int m, Integer[] f, Integer[] s) {
        // count用于保存每个文件出现的次数
        HashMap<Integer, Integer> count = new HashMap<>();
        // size用于保存文件的大小，即扫描成本
        HashMap<Integer, Integer> size = new HashMap<>();

        for (int i = 0; i < f.length; i++) {
            // k是文件标识
            Integer k = f[i];
            count.put(k, count.getOrDefault(k, 0) + 1);
            size.putIfAbsent(k, s[i]);
        }

        int ans = 0;
        for (Integer k : count.keySet()) {
            // 选择每次都重新扫描的成本  和  扫描一次+缓存的成本  中最小的
            ans += Math.min(count.get(k) * size.get(k), size.get(k) + m);
        }

        return ans;
    }

}
