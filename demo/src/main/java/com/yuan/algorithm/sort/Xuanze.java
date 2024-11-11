package com.yuan.algorithm.sort;

/**
 *  每次排序找到最小的数放到最前面
 */
public class Xuanze {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 88, 35, 48};
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
           for (int j=i+1;j<arr.length;j++){
               if(min> arr[j]){
                   min = arr[j];
               }
           }
           arr[i] = min;
        }
        for (int i : arr) {
            System.out.print(i+",");
        }

    }
}
