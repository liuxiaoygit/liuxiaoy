package com.yuan.dp;


import org.junit.Test;

import java.util.*;
import java.util.Stack;

public class quchong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] issues = sc.nextLine().split(",");
        String[] answers = sc.nextLine().split(",");

        System.out.println(getResult(issues, answers));
    }

    public static String getResult(String[] issues, String[] answers) {
        ArrayList<String> ans = new ArrayList<>();

        for (String issue : issues) {
            String str1 = getSortedAndDistinctStr(issue);
            boolean find = false;

            for (String answer : answers) {
                String str2 = getSortedAndDistinctStr(answer);
                if(str1.equals(str2)) {
                    ans.add(answer);
                    find = true;
                    // break; // 如果一个谜面对应多个谜底，这里就不能break，如果一个谜面只对应一个谜底，那这里就要break，考试的时候都试下
                }
            }

            if(!find) {
                ans.add("not found");
            }
        }

        StringJoiner sj = new StringJoiner(",","","");
        for (String an : ans) {
            sj.add(an);
        }
        return sj.toString();
    }

    @Test
    public void res(){
        java.util.Stack<String> stack =new Stack<>();
        stack.push("usr");
        stack.push("a");
        stack.push("b");

        Deque<String> queue = new LinkedList<>();
        while (!stack.isEmpty()){
            String cur = stack.pop();
            queue.addFirst(cur);
        }
        System.out.println(queue);
        StringJoiner sj = new StringJoiner("/","","");
        for (String an : queue) {
            sj.add(an);
        }
        System.out.println(sj.toString());
    }

    public static String getSortedAndDistinctStr(String str) {
        // HashSet不会记录元素加入顺序，会按照hash算法排序，因此不需要额外排序
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) set.add(c);
        return set.toString();
    }
}

