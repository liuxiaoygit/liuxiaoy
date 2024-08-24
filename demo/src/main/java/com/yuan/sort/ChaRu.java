package com.yuan.sort;

/**
 *  每次取一个数和前面的数比较如果小就交换位置
 */

public class ChaRu {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 5, 88, 35, 48};
        sort(arr);
        printArr(arr);
    }

    private static void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
