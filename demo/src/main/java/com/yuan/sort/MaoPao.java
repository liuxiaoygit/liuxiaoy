package com.yuan.sort;

/**
 *  比较相邻两个数的大小 如果前面大于后面交换位置
 */

public class MaoPao {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 5, 88, 35, 48};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
