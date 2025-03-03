package com.yuan.algorithm.leedcode;


import java.util.*;

/**
 *题目描述
 *
 * 小王设计了一个简单的猜字谜游戏，游戏的谜面是一个错误的单词，比如nesw，玩家需要猜出谜底库中正确的单词。猜中的要求如下：
 *
 * 对于某个谜面和谜底单词，满足下面任一条件都表示猜中：
 *
 * （1） 变换顺序以后一样的，比如通过变换w和e的顺序，nwes跟news是可以完全对应的；
 *
 *  （2）字母去重以后是一样的，比如woood和wood是一样的，它们去重后都是wod
 *
 *  请你写一个程序帮忙在谜底库中找到正确的谜底。 谜面是多个单词，都需要找到对应的谜底，如果找不到的话，返回“not found”
 *
 *  输入描述
 *
 *  谜面单词列表，以","分隔
 *
 *  谜底库单词列表，以","分隔
 *
 *  输出描述
 *
 *  匹配到的正确单词列表，以","分隔,如果找不到，返回"not found"
 *
 *  备注
 *
 * 单词的数量N的范围： 0<N<1000
 *
 * 词汇表数量M的范围： 0<M<1000
 *
 * 单词的长度P的范围： 0<P<203
 *
 * 输入的字符只有小写英文字母，没有其他字符。
 *
 * 示例1
 *
 * 输入
 *
 * conection
 *
 * connection,today
 */
public class Caizimi {

    public static String convert(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputMian = scanner.nextLine();
        String inputDi = scanner.nextLine();

        String[] mian = inputMian.split(",");
        String[] di = inputDi.split(",");

        Set<String> st = new HashSet<>();
        for (String i : mian) {
            st.add(convert(i));
        }

        List<String> res = new ArrayList<>();
        for (String i : di) {
            String now = convert(i);
            if (st.contains(now)) {
                res.add(i);
            }
        }

        if (res.isEmpty()) {
            System.out.println("not found");
        } else {
            System.out.println(String.join(",", res));
        }

        scanner.close();
    }

}
