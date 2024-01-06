package com.example.websocket;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串,如果存在多个字串，以第一个出现的字串为结果。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: abc
 * <p>
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: b
 * <p>
 * 示例 3:
 * 输入: "pww
 */
public class Test {
    public static void main(String[] args) {
        String str = "pww";
        System.out.println(getResult(str));
    }

    private static String getResult(String str) {
        if (null == str || str.length() == 1) {
            return str;
        }
        String[] arr = str.split("");
        String res = "";
        int left = 0;
        int right = 1;
        Set<String> tempSet = new HashSet<>();
        tempSet.add(arr[0]);
        while (right < arr.length) {
            if (!arr[right].equals(arr[right - 1]) && !tempSet.contains(arr[right])) {
                tempSet.add(arr[right]);
                right++;
            } else {
                String curStr = getMaxSub(left, right, arr);
                if(res.length() < curStr.length()){
                    res = curStr;
                }
                left = right;
                right++;
            }
        }
        return res;
    }

    private static String getMaxSub(int left, int right, String[] arr) {
        String res = "";
        for (int i = left; i < right; i++) {
            res = res + arr[i];
        }
        return res;
    }

}
