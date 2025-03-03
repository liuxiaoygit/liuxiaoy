package com.yuan.algorithm.leedcode;

import java.util.*;

public class WordsLength {

    /**
     * 题目描述
     * 给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第k长的子串的长度，相同字母只取最长的那个子串。
     * <p>
     * 输入描述
     * 第一行有一个子串(1<长度<=100)，只包含大写字母。
     * 第二行为 k的值
     * <p>
     * 输出描述
     * 输出连续出现次数第k多的字母的次数。
     * <p>
     * 补充说明
     * 若子串中只包含同一字母的子串数小于k，则输出-1
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int k = sc.nextInt();
//        int res = excu(s.toCharArray(), k);
//        System.out.printf("%d", res);
//    }
//
//    private static int excu(char[] strs, int k) {
//        if (strs.length < k) {
//            return -1;
//        }
//        Set set = new HashSet();
//        int left = 0;
//        int right = 0;
//        int res = 0;
//        while (right < strs.length) {
//            if (strs[left] == strs[right]) {
//                right++;
//                if (right - left == k && !set.contains(strs[left])) {
//                    res++;
//                }
//            } else {
//                set.add(strs[left]);
//                left = right;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        int []mp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int cnt = 1;
            while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(j)) {
                j++;
                cnt++;
            }
            int id = s.charAt(j) - 'A';
            mp[id] = Math.max(mp[id], cnt);
            i = j;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (mp[i] > 0) res.add(mp[i]);
        }
        res.sort((x, y)->y.compareTo(x));
        if (n > res.size() || n <= 0)
            System.out.println(-1);
        else
            System.out.println(res.get(n - 1));
    }
}
