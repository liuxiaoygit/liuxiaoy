package com.yuan.dp.huadong;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ZuixiaoJiaoHuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int k = sc.nextInt();
        System.out.println(getResult(arr,k));

    }

    private static  int getResult(Integer[] arr, int k){
        List<Integer> farr = Arrays.stream(arr).filter(item -> item < k).collect(Collectors.toList());
        int count = farr.size();
        if(count == 1) return 0;
        // 先统计起点在0位置（即left=0）的滑动窗口的交换次数，得到一个minSwapCount初始值
        int minSwapCount = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] >= k) {
                minSwapCount++;
            }
        }
        // 然后统计起点（left）在1~arr.length-count位置的滑动窗口的交换次数
        // 可以转化为求解终点（right）在count~arr.length位置的滑动窗口的交换次数
        int tmpSwapCount = minSwapCount;
        for (int j = count; j < arr.length; j++) {
            // 上一轮的left，即滑窗失去的元素的索引
            int preLeft = j - count;
            // 本轮的right，即滑窗新增的元素的索引
            int curRight = j;
            if (arr[preLeft] >= k && arr[curRight] < k) {
                tmpSwapCount--;
            } else if (arr[preLeft] < k && arr[curRight] >= k) {
                tmpSwapCount++;
            }
            minSwapCount = Math.min(minSwapCount, tmpSwapCount);
        }
        return minSwapCount;
    }

}
