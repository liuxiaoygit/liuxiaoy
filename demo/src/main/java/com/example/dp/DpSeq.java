package com.example.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DpSeq {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getResult(arr, n));
    }

    public static int getResult(int[] arr, int n) {
        HashMap<Integer, ArrayList<Integer[]>> ranges = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            ranges.putIfAbsent(sum, new ArrayList<>());
            ranges.get(sum).add(new Integer[]{i, i});

            for (int j = i + 1; j < n; j++) {
                sum += arr[j];
                ranges.putIfAbsent(sum, new ArrayList<>());
                ranges.get(sum).add(new Integer[]{i, j});
            }
        }

        int max = 0;
        for (Integer key : ranges.keySet()) {
            ArrayList<Integer[]> range = ranges.get(key);
            max = Math.max(max, disjoint(range));
        }

        return max;
    }

    public static int disjoint(ArrayList<Integer[]> ranges) {
        int count = 1;
        ranges.sort((a, b) -> a[1] - b[1]);

        Integer t = ranges.get(0)[1];
        for (int i = 1; i < ranges.size(); i++) {
            Integer[] range = ranges.get(i);
            Integer l = range[0];
            Integer r = range[1];

            if (t < l) {
                count++;
                t = r;
            }
        }
        return count;
    }

}
