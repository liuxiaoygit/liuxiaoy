package com.yuan.algorithm.sort;

/**
 *
 */

public class GuiBing {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 7, 4, 6, 8, 9, 1};
        sort(arr, 0, arr.length-1);
        printArr(arr);
    }

    private static void sort(int arr[], int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        sort(arr, 0, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }


    private static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
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
