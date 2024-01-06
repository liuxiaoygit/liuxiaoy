package com.example.test;

/**
 * 每次取一个数和前面的数比较如果小就交换位置
 */

public class KuaiPai {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 5, 88, 35, 48};
        sort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = position(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }


    private static int position(int arr[], int leftBound, int rightBound) {
        int left = leftBound;
        int right = rightBound -1;
        int privot = arr[rightBound];
        while (left < right) {
            while (left <= right && arr[left] <= privot) {
                left++;
            }
            while (left <= right && arr[right] > privot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr,left,rightBound);
        return left;
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
