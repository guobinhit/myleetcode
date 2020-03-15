package com.hit.basmath.interview.we_meet.huawei;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/2,下午4:40
 * @description
 */
public class TwoStringOne {
    public static boolean judgeTwoStr(String s1, String s2) {
        if (s1.equals(s2)) return false;
        if (Math.abs(s1.length() - s2.length()) >= 2) return false;
        // 长度相同，替换字符
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    int j = i + 1;
                    while (j < s1.length()) {
                        if (s1.charAt(j) == s2.charAt(j)) {
                            j++;
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else {
            // 长度差异，短字符串新增一个字符
            String shortStr;
            String longStr;
            if (s1.length() > s2.length()) {
                shortStr = s2;
                longStr = s1;
            } else {
                shortStr = s1;
                longStr = s2;
            }
            for (int i = 0; i < shortStr.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    int j = i + 1;
                    while (j < longStr.length()) {
                        if (shortStr.charAt(j - 1) != longStr.charAt(j)) {
                            return false;
                        }
                        j++;
                    }
                    return true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        System.out.println(judgeTwoStr(s1, s2));
    }
}
