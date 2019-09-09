package com.hit.basmath.learn.others;

import java.util.Scanner;

/**
 * 592. Fraction Addition and Subtraction
 * <p>
 * Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.
 * <p>
 * Example 1:
 * <p>
 * Input:"-1/2+1/2"
 * Output: "0/1"
 * <p>
 * Example 2:
 * <p>
 * Input:"-1/2+1/2+1/3"
 * Output: "1/3"
 * <p>
 * Example 3:
 * <p>
 * Input:"1/3-1/2"
 * Output: "-1/6"
 * <p>
 * Example 4:
 * <p>
 * Input:"5/3+1/3"
 * Output: "2/1"
 * <p>
 * Note:
 * <p>
 * The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
 * Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
 * The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
 * The number of given fractions will be in the range [1,10].
 * The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
 */
public class _592 {
    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            A = A * b + a * B;
            B *= b;
            int g = gcd(A, B);
            A /= g;
            B /= g;
        }
        return A + "/" + B;
    }

    private int gcd(int a, int b) {
        return a != 0 ? gcd(b % a, a) : Math.abs(b);
    }
}
