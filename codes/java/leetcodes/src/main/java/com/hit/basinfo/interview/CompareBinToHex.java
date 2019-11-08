package com.hit.basinfo.interview;

/**
 * author:Charies Gavin
 * date:2018/12/29,15:30
 * https:github.com/guobinhit
 * description: 编写函数检查某个二进制（以字符串形式传入）是否等于以字符串表示的十六进制数
 */
public class CompareBinToHex {
    public static void main(String[] args) {
        String binary = "00001101";
        String hex = "0f";
        System.out.println(compareBinToHex(binary, hex));
    }

    public static boolean compareBinToHex(String binary, String hex) {
        int binDigit = convertToBase(binary, 2);
        int hexDigit = convertToBase(hex, 16);
        if (binDigit < 0 || hexDigit < 0) {
            return false;
        } else {
            return binDigit == hexDigit;
        }
    }

    /**
     * 转换字符串到指定的 base 进制的数值表示，其中 base 的值仅能为 2 或者 16
     *
     * @param number
     * @param base
     * @return
     */
    public static int convertToBase(String number, int base) {
        if (base < 2 || (base > 10 && base != 16)) {
            return -1;
        }
        int value = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = digitToValue(number.charAt(i));
            if (digit < 0 || digit >= base) {
                return -1;
            }
            int exp = number.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }

    /**
     * 将字符转换为数值
     *
     * @param c
     * @return
     */
    public static int digitToValue(char c) {
        /**
         * 0 ~ 9 ASCII code is 48 ~ 57
         * A ~ F ASCII code is 58 ~ 63
         * a ~ f ASCII code is 97 ~ 102
         */
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'F') {
            return 10 + c - 'A';
        } else if (c >= 'a' && c <= 'f') {
            return 10 + c - 'a';
        }
        return -1;
    }
}
