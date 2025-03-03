package com.yuan.algorithm.zuochengyun;

import java.util.Scanner;

/**
 * 给定一个字符串，由B和G组成，请计算把所有的G移动到字符串的左侧，
 * 所有的B移动到字符串的右侧，只允许在字符串内部进行交换操作，
 * 请返回至少需要交换几次。
 * 例如：
 * GBBG
 * 至少需要交换1次，交换B和G
 * 例如：
 * GGGGBBBB
 * 至少需要交换0次
 * 例如：
 * BBBGGGG
 * 至少需要交换6次
 * 例如：
 * BGBGB
 * 至少需要交换2次
 */
public class ZuiXiaoJiaohuan {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        if(s.length() <= 1){
            System.out.println(0);
        }
        int step1 = 0;
        int step2 = 0;
        int gi = 0;
        int bi = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'G'){
                step1 += i - gi;
                gi++;
            }else{
                step2 += i - bi;
                bi++;
            }
        }
        System.out.println(Math.min(step1, step2));
    }
}
