package com.hit.basmath.interview.we_meet.alibaba;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,下午8:36
 * @description
 */
public class MM {
    private static StringBuilder result = new StringBuilder();
    private static final int MAXLEN = 3; //最大字符数
    private static int len = MAXLEN; //取词长度
    private static int curIndex = 0; //当前下标

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.next();
        maxMatching(sentence);
        System.out.println(result);
    }

    private static void maxMatching(String sentence) {
        while (curIndex < sentence.length()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        new FileInputStream("/Users/bin.guo/Desktop/words.txt"), "GBK"));
                String subStr;
                if (curIndex + len > sentence.length()) {
                    subStr = sentence.substring(curIndex, sentence.length());
                } else {
                    subStr = sentence.substring(curIndex, curIndex + len);
                }
                String string;
                while ((string = br.readLine()) != null) {
                    String[] line = string.split(",");
                    if (line[0].equals(subStr)) {
                        result.append(subStr).append("/");
                        curIndex += len;
                        len = MAXLEN + 1;
                    }
                }
                len--;
                if (len == 0) {
                    result.append("该字符不存在").append("/");
                    curIndex++;
                    len = MAXLEN;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
