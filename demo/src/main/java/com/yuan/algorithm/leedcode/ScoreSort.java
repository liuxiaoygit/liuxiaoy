package com.yuan.algorithm.leedcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 小明来到某学校当老师，需要将学生按考试总分或单科分数进行排名，你能帮帮他吗？
 * <p>
 * 输入描述
 * 第 1 行输入两个整数，学生人数 n 和科目数量 m。
 * <p>
 * 0 < n < 100
 * 0 < m < 10
 * 第 2 行输入 m 个科目名称，彼此之间用空格隔开。
 * <p>
 * 科目名称只由英文字母构成，单个长度不超过10个字符。
 * 科目的出现顺序和后续输入的学生成绩一一对应。
 * 不会出现重复的科目名称。
 * 第 3 行开始的 n 行，每行包含一个学生的姓名和该生 m 个科目的成绩（空格隔开）
 * <p>
 * 学生不会重名。
 * 学生姓名只由英文字母构成，长度不超过10个字符。
 * 成绩是0~100的整数，依次对应第2行种输入的科目。
 * 第n+2行，输入用作排名的科目名称。若科目不存在，则按总分进行排序。
 * <p>
 * 输出描述
 * 输出一行，按成绩排序后的学生名字，空格隔开。成绩相同的按照学生姓名字典顺序排序。
 * <p>
 * 用例1
 * 输入
 * 3 2
 * yuwen shuxue
 * fangfang 95 90
 * xiaohua 88 95
 * minmin 100 82
 * shuxue
 * 输出
 * xiaohua fangfang minmin
 * 说明
 * 按shuxue成绩排名，依次是xiaohua、fangfang、minmin
 */
public class ScoreSort {

    // 科目
    static Map<String, Integer> mp = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 科目放入map
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            mp.put(s, i + 1);
        }

        for (int i = 0; i < n; i++) {
            Stu stu = new Stu();
            stu.name = sc.next();
            int sum = 0;
            for (int j = 0; j < m; j++) {
                stu.fen.add(sc.nextInt());
                sum+= stu.fen.get(j);
            }

        }

    }


}
