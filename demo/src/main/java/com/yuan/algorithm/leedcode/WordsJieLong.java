package com.yuan.algorithm.leedcode;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordsJieLong {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String[] words = {"akdkdkdk", "b", "c", "deeeefsdf", "e", "f", "g", "h", "i", "j", "kgggggggdfd", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int index = 0;
        StringBuffer bf = new StringBuffer(words[index]);
        Map<String, String> wordMap = new HashMap<>();
        for (String word : words) {
            if (word.equals(words[index])) {
                continue;
            }
            String start = word.substring(0, 1);
            if (wordMap.containsKey(start) && word.length() > wordMap.get(start).length()) {
                wordMap.put(start, word);
            } else if (!wordMap.containsKey(start)) {
                wordMap.put(start, word);
            }
        }
        Set keySet = new HashSet();

        while (true) {
            String key= bf.substring(bf.length() - 1, bf.length());
            String s1 = wordMap.get(key);
            if (StringUtils.isEmpty(s1) || keySet.contains(key)) {
                break;
            }
            bf.append(s1);
            keySet.add(key);
        }
        System.out.println(bf);
    }
}
