package com.hit.basmath.learn.others;

import java.util.*;

/**
 * 736. Parse Lisp Expression
 * <p>
 * You are given a string expression representing a Lisp-like expression to return the integer value of.
 * <p>
 * The syntax for these expressions is given as follows.
 * <p>
 * 1. An expression is either an integer, a let-expression, an add-expression, a mult-expression, or an assigned variable. Expressions always evaluate to a single integer.
 * 2. (An integer could be positive or negative.)
 * 3. A let-expression takes the form (let v1 e1 v2 e2 ... vn en expr), where let is always the string "let", then there are 1 or more pairs of alternating variables and expressions, meaning that the first variable v1 is assigned the value of the expression e1, the second variable v2 is assigned the value of the expression e2, and so on sequentially; and then the value of this let-expression is the value of the expression expr.
 * 4. An add-expression takes the form (add e1 e2) where add is always the string "add", there are always two expressions e1, e2, and this expression evaluates to the addition of the evaluation of e1 and the evaluation of e2.
 * 5. A mult-expression takes the form (mult e1 e2) where mult is always the string "mult", there are always two expressions e1, e2, and this expression evaluates to the multiplication of the evaluation of e1 and the evaluation of e2.
 * 6. For the purposes of this question, we will use a smaller subset of variable names. A variable starts with a lowercase letter, then zero or more lowercase letters or digits. Additionally for your convenience, the names "add", "let", or "mult" are protected and will never be used as variable names.
 * 7. Finally, there is the concept of scope. When an expression of a variable name is evaluated, within the context of that evaluation, the innermost scope (in terms of parentheses) is checked first for the value of that variable, and then outer scopes are checked sequentially. It is guaranteed that every expression is legal. Please see the examples for more details on scope.
 * <p>
 * Evaluation Examples:
 * <p>
 * Input: (add 1 2)
 * Output: 3
 * <p>
 * Input: (mult 3 (add 2 3))
 * Output: 15
 * <p>
 * Input: (let x 2 (mult x 5))
 * Output: 10
 * <p>
 * Input: (let x 2 (mult x (let x 3 y 4 (add x y))))
 * Output: 14
 * Explanation: In the expression (add x y), when checking for the value of the variable x,
 * we check from the innermost scope to the outermost in the context of the variable we are trying to evaluate.
 * Since x = 3 is found first, the value of x is 3.
 * <p>
 * Input: (let x 3 x 2 x)
 * Output: 2
 * Explanation: Assignment in let statements is processed sequentially.
 * <p>
 * Input: (let x 1 y 2 x (add x y) (add x y))
 * Output: 5
 * Explanation: The first (add x y) evaluates as 3, and is assigned to x.
 * The second (add x y) evaluates as 3+2 = 5.
 * <p>
 * Input: (let x 2 (add (let x 3 (let x 4 x)) x))
 * Output: 6
 * Explanation: Even though (let x 4 x) has a deeper scope, it is outside the context
 * of the final x in the add-expression.  That final x will equal 2.
 * <p>
 * Input: (let a1 3 b2 (add a1 1) b2)
 * Output 4
 * Explanation: Variable names can contain digits after the first character.
 * <p>
 * Note:
 * <p>
 * The given string expression is well formatted: There are no leading or trailing spaces, there is only a single space separating different components of the string, and no space between adjacent parentheses. The expression is guaranteed to be legal and evaluate to an integer.
 * The length of expression is at most 2000. (It is also non-empty, as that would not be a legal expression.)
 * The answer and all intermediate calculations of that answer are guaranteed to fit in a 32-bit integer.
 */
public class _736 {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(String e, Map<String, Deque<Integer>> map) {
        char c = e.charAt(1);          // the expression must start with "(add " or "(mult " or "(let ".

        if (c == 'a') {                // "add" expression
            return evaluateAdd(e, map);
        } else if (c == 'm') {         // "mult" expression
            return evaluateMult(e, map);
        } else if (c == 'l') {         // "let" expression
            return evaluateLet(e, map);
        } else {
            return 0;                  // illegal expression so return 0
        }
    }

    private int evaluateAdd(String e, Map<String, Deque<Integer>> map) {
        int offset = 5;      // the expression starts with "(add ", so offset starts at 5.
        String o1 = getOperand(e, offset);  // 1st operand

        offset += o1.length() + 1;
        String o2 = getOperand(e, offset);  // 2nd operand

        return evaluateOperand(o1, map) + evaluateOperand(o2, map);
    }

    private int evaluateMult(String e, Map<String, Deque<Integer>> map) {
        int offset = 6;      // the expression starts with "(mult ", so offset starts at 6.
        String o1 = getOperand(e, offset);  // 1st operand

        offset += o1.length() + 1;
        String o2 = getOperand(e, offset);  // 2nd operand

        return evaluateOperand(o1, map) * evaluateOperand(o2, map);
    }

    private int evaluateLet(String e, Map<String, Deque<Integer>> map) {
        List<String> variables = new ArrayList<>();  // list of variables assigned in this "let" expression
        int res = 0;     // the result of this "let" expression
        int offset = 5;  // the expression starts with "(let ", so offset starts at 5.

        while (offset < e.length()) {
            String o1 = getOperand(e, offset);  // 1st operand
            offset += o1.length() + 1;

            String o2 = getOperand(e, offset);  // 2nd operand

            if (o2 == null) {
                res = evaluateOperand(o1, map); // if 2nd operand is null, we reached the last operand
                break;
            }

            offset += o2.length() + 1;

            variables.add(o1);  // record the variable

            if (!map.containsKey(o1)) map.put(o1, new ArrayDeque<>());

            map.get(o1).offerFirst(evaluateOperand(o2, map));  // do the assignment
        }

        // pop out assigned values before returning from this "let" expression
        for (int i = variables.size() - 1; i >= 0; i--) {
            String variable = variables.get(i);
            Deque<Integer> stack = map.get(variable);
            stack.pollFirst();
            if (stack.isEmpty()) map.remove(variable);
        }

        return res;
    }

    private String getOperand(String e, int offset) {
        if (offset >= e.length()) return null;  // invalid offset

        char c = e.charAt(offset);
        int start = offset;

        if (c == '-' || Character.isDigit(c)) {  // operand is an integer
            if (c == '-') offset++;
            while (offset < e.length() && Character.isDigit(e.charAt(offset))) offset++;

        } else if (Character.isLowerCase(c)) {  // operand is a variable
            while (offset < e.length() && Character.isLetterOrDigit(e.charAt(offset))) offset++;

        } else {                                // operand is another expression enclosed in parentheses
            for (int cnt = 0; offset < e.length(); ) {
                c = e.charAt(offset++);
                if (c == '(') cnt++;
                if (c == ')') cnt--;
                if (cnt == 0) break;
            }
        }

        return e.substring(start, offset);
    }

    private int evaluateOperand(String e, Map<String, Deque<Integer>> map) {
        char c = e.charAt(0);

        if (c == '-' || Character.isDigit(c)) {  // operand is an integer so parse it
            return Integer.parseInt(e);

        } else if (Character.isLowerCase(c)) {  // operand is a variable so look it up
            return map.get(e).peekFirst();

        } else {                               // operand is another expression so evaluate it recursively
            return evaluate(e, map);
        }
    }
}
