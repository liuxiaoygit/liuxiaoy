package com.yuan.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Erfen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] fields = new int[m];
        for (int i = 0; i < m; i++) {
            fields[i] = sc.nextInt();
        }

        System.out.println(getResult(n, fields));
    }

    /**
     * @param n 表示施肥任务必须在n天内（含n天）
     * @param fields fields[i]表示果林 i 的面积
     * @return 最小施肥机的能效 k
     */
    public static int getResult(int n, int[] fields) {
        Arrays.sort(fields);

        double min = 0; // 最小果林面积
        double max = fields[fields.length - 1]; // 最大果林面积

        int ans = -1;

        // 我们需要找min,max中间值作为k效率，如果min,max间距小于1，则没有中间值，循环结束
        while (min <= max) {
            int k = (int) Math.ceil((min + max) / 2);

            int res = check(k, n, fields);

            if (res > 0) min = k + 1; // k的效率太低，导致花费的时间超过了n天，因此要提高k效率
                /* 2023.02.07 网友指正：施肥任务必须在n天内（含n天），表示不需要一定是n天完成，可以少于n天完成，因此res < 0 时的k也是符合要求的k */
                //      else if (res < 0) max = k; // k的效率太高，导致花费的时间少于n天，因此要降低k效率
            else {
                ans = k; // k的效率刚好，花费的时间就是n天，则此时k效率就是一个题解，但可能不是最优解
                max = k - 1; // 继续尝试找更小的k
            }
        }

        return ans;
    }

    /**
     * @param k 能效k
     * @param n 指定天数
     * @param fields 所有果林面积
     * @return 基于能效k需要spend天施肥完所有果林，返回spend - n
     */
    public static int check(int k, int n, int[] fields) {
        int spend = 0;
        for (int field : fields) {
            if (k >= field) spend++; // k效率比field果林面积大，则field果林只需要一天
            else spend += Math.ceil(field / (double) k); // k效率比field果林面积小，则需要Math.ceil(field / k)天
        }

        return spend - n;
    }

}
