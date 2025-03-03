package com.yuan.algorithm.leedcode;

import java.util.Scanner;

/**
 * IGMP协议中，有一个字段称作最大响应时间(Max Response Time),HOST收到查询报文，解折出MaxResponsetime字段后，需要在[0,MaxResponseTime]时间(s)内选取随机时间回应一个响应报文，如果在随机时间内收到一个新的查询报文，则会根据两者时间的大小，选取小的一方刷新回应时间。
 *
 * 最大响应时间有如下计算方式：
 *
 * 当Max Resp Code <128, Max Resp Time = Max Resp Code;
 *
 * 当Max Resp Code≥128,
 *
 *   0 1 2  3 4 5 6  7
 *
 * +-+-+-+-+-+-+-+-+
 *
 * | 1| exp  |  mant|
 *
 * +-+-+-+-+-+-+-+-+
 *
 * Max Resp Time =(mant|0x10)<<(exp+3);注：exp最大响应时间的高5~7位mant为最大响应时间的低4位。
 *
 * 其中接收到的MaxRespCode最大值为255,以上出现所有字段均为无符号数。
 *
 * 现在我们认为HOST收到查询报文时，选取的随机时间必定为最大值，现给出HOST收到查询报文个数C,HOST收到该报文的时间T,
 *
 * 以及查询报文的最大响应时间字段值M,请计算出HOST发送响应报文的时间。
 *
 * 输入描述
 *
 * 第一行为查询报文个数C, 后续每行分别为HOST收到报文时间T,及最大响应时间M,以空格分割。
 *
 * 输出描述
 *
 * HOST发送响应报文的时间。
 *
 * 备注
 *
 * 用例确定只会发送一个响应报文，不存在计时结束后依然收到查询报文的情况。
 *
 * 用例1
 *
 * 输入
 * 3
 * 0 20
 * 1 10
 * 8 20
 * 输出
 * 11
 * 说明
 * 收到3个报文，
 * 第0秒收到第1个报文，响应时间为20秒，则要到0+20=20秒响应；
 * 第1秒收到第2个报文，响应时间为10秒，则要到1+10=11秒响应，与上面的报文的响应时间比较获得响应时间最小为11秒；
 * 第8秒收到第3个报文，响应时间为20秒，则要到8+20=28秒响应，与第上面的报文的响应时间比较获得响应时间最小为11秒；
 * 最终得到最小响应报文时间为11秒
 * 示例2
 *
 * 输入
 * 2
 * 0 255
 * 200 60
 * 输出
 * 260
 * 说明
 * 收到2个报文，
 * 第0秒收到第1个报文，响应时间为255秒，则要到(1510×10)<<(7+3)=31744秒响应；(mant=15,exp=7)
 * 第200秒收到第2个报文，响应时间为60秒，则要到200+60-260秒响应，
 * 与第上面的报文的响应时间比较获得响应时间最小为260秒：
 * 最终得到最小响应报文时间为260秒
 *
 */
public class Baowenxiangying {
        public static int calc(int m) {
            if (m < 128) {
                return m;
            }
            int exp = m & 0b01110000;
            exp >>= 4;
            int mant = m & 0b1111;
            int base = mant | 0x10;
            int shift = exp + 3;
            return base << shift;
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int up = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int calculatedValue = x + calc(y);
                if (calculatedValue < up) {
                    up = calculatedValue;
                }
            }
            System.out.println(up);
            scanner.close();
        }

}
