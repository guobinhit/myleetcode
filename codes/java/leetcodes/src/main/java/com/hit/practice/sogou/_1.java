package com.hit.practice.sogou;

/**
 * 十进制数字用A~Z表示成二十六进制
 */
public class _1 {

    /**
     * 题目：
     * <p>
     * 在Excel中，用A表示第一列，B表示第二列...Z表示第26列，AA表示第27列，AB表示第28列...依次列推。
     * 请写出一个函数，输入用字母表示的列号编码，输出它是第几列？
     * <p>
     * 思路：
     * <p>
     * 这道题实际上考察的是把二十六进制表示成十进制数字，将输入的字符串先转换成字符数组，遍历数组中的每一个字符，
     * 用这个字符减去A再加1就是该位对应的十进制数，然后乘以26的相应次方，最后把这些数加起来就是结果了。
     * 可能很多人会有疑惑为什么要加1，因为十进制是用0-9表示，那么二十六进制就应该用0-25表示，
     * 但是这里是A-Z，就相当于1-26，所以算出来的数需要加1。
     * <p>
     * 写代码之前，先补充一下ASCII码几个基本知识点：
     * <p>
     * 0：48
     * A：65
     * a：97
     * <p>
     * 规律：
     * <p>
     * 数字在前，大写字母其后，最后是小写字母，小写字母与大写字母差32。
     * 上边给出了字符'0'、'A'、'a'相对应的整型数，其余的字符按照顺序都可以算出来。
     *
     * @param str 列编码
     * @return 行数
     */
    private int titleToNumber(String str) {
        // 判空
        if (str == null || "".equals(str)) {
            return -1;
        }
        // 将字符串转换为字符数组
        char[] strArr = str.toCharArray();
        // 指数
        int exp = 0;
        // 行数
        int col = 0;
        for (int i = strArr.length - 1; i >= 0; i--) {
            col += (strArr[i] - 'A' + 1) * Math.pow(26, exp);
            exp++;
        }
        return col;
    }

    /**
     * 题目：
     * <p>
     * 在Excel中，用A表示第一列，B表示第二列...Z表示第26列，AA表示第27列，AB表示第28列...依次列推。
     * 请写出一个函数，输入一个数表示第几列，输出用字母表示的列号编码？
     * <p>
     * 思路：
     * <p>
     * 这道题思路和上道题完全相反，考察的是把十进制进制数字表示成二十六进制，
     * 用输入的数字col模26得到temp，temp即为二十六进制数字的最后一位，
     * 用temp + 'A' - 1即可得到所对应的A~Z中的字母；接着用输入的数字col除以26，
     * 用这个结果继续寻找倒数第二位所对应的字符，直到col为0。
     * 但是，temp=0的时候比较特殊，比如输入的数字col=26，col%26=0，本来应该输出Z，
     * 结果输出的是@，所以把temp=0的情况单独拿出来判断一下，当temp=0时，置temp=26，
     * 然后将col-1，这时输入26将会得到正确答案Z。
     * 最后注意，刚才输出的结果都是从最后一位开始的，
     * 利用StringBuilder的reverse()方法将刚才得到的结果反转，返回就OK了。
     *
     * @param col 行数
     * @return 列编码
     */
    public String convertToTitle(int col) {
        StringBuilder builder = new StringBuilder();
        while (col != 0) {
            int temp = col % 26;
            col = col / 26;
            if (temp == 0) {
                temp = 26;
                col = col - 1;
            }
            builder.append((char) ('A' + temp - 1));
        }
        return builder.reverse().toString();
    }
}
