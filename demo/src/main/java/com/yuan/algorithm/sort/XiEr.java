package com.yuan.algorithm.sort;

/**
 *  间隔4取出数据进行快拍 然后间隔2 最后间隔1快排
 */
public class XiEr {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 5, 88, 35, 48, 12, 34, 14, 45, 56, 17};
        sort(arr);
        printArr(arr);
    }

    private static void sort(int arr[]) {
        for (int gap = 4; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i+=gap) {
                for (int j = i; j > gap-1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
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
