package com.example.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TuoPu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int taskNum = sc.nextInt();
        int relationsNum = sc.nextInt();

        int[][] relations = new int[relationsNum][2];
        for (int i = 0; i < relationsNum; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        System.out.println(getResult(relations, taskNum));
    }

    public static int getResult(int[][] relations, int taskNum) {
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();
        int[] inDegree = new int[taskNum];

        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];

            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b); // a的下一个顶点有b
            inDegree[b]++; // b顶点的入度++
        }

        LinkedList<Integer[]> queue = new LinkedList<>();
        int t = 1;

        for (int i = 0; i < taskNum; i++) {
            if (inDegree[i] == 0) {
                queue.add(new Integer[] {i, t}); // i含义是入度为0的顶点，t含义是该顶点所处建站时间
            }
        }

        while (queue.size() > 0) {
            Integer[] tmp = queue.removeFirst(); // 注意这里为了维持t，一定要使用队列先进先出，出队代表删除某顶点
            int task = tmp[0];
            int time = tmp[1];

            if (next.containsKey(task) && next.get(task).size() > 0) {
                for (Integer nxt : next.get(task)) {
                    // 该顶点被删除，则其后继点的入度值--，若--后入度为0，则将成为新的出队点
                    if (--inDegree[nxt] == 0) {
                        t = time + 1; // 此时建站时间+1
                        queue.add(new Integer[] {nxt, t});
                    }
                }
            }
        }

        return t;
    }
}
