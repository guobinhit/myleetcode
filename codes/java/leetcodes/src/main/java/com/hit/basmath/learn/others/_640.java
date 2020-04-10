package com.hit.basmath.learn.others;

/**
 * 640. Solve the Equation
 * <p>
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * <p>
 * Example 2:
 * <p>
 * Input: "x=x"
 * Output: "Infinite solutions"
 * <p>
 * Example 3:
 * <p>
 * Input: "2x=x"
 * Output: "x=0"
 * <p>
 * Example 4:
 * <p>
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * <p>
 * Example 5:
 * <p>
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class _640 {
    public String solveEquation(String equation) {
        int[] res = evaluateExpression(equation.split("=")[0]),
                res2 = evaluateExpression(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        if (res[0] == 0) return "No solution";
        return "x=" + res[1] / res[0];
    }

    private int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res = new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0] += 1;
            else if (token.equals("-x")) res[0] -= 1;
            else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else res[1] += Integer.parseInt(token);
        }
        return res;
    }
}
