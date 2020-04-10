package com.hit.basmath.interview.top_interview_questions.easy_collection.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 412. Fizz Buzz
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * <p>
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class _412 {
    public List<String> fizzBuzz(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                // Divides by both 3 and 5, add FizzBuzz
                ans.add("FizzBuzz");
            } else if (divisibleBy3) {
                // Divides by 3, add Fizz
                ans.add("Fizz");
            } else if (divisibleBy5) {
                // Divides by 5, add Buzz
                ans.add("Buzz");
            } else {
                // Not divisible by 3 or 5, add the number
                ans.add(Integer.toString(num));
            }
        }

        return ans;
    }

    public List<String> fizzBuzz2(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            String numAnsStr = "";

            if (divisibleBy3) {
                // Divides by 3, add Fizz
                numAnsStr += "Fizz";
            }

            if (divisibleBy5) {
                // Divides by 5, add Buzz
                numAnsStr += "Buzz";
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }

    public List<String> fizzBuzz3(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();

        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBizzDict =
                new HashMap<Integer, String>() {
                    private static final long serialVersionUID = 7966206953841139705L;
                    {
                        put(3, "Fizz");
                        put(5, "Buzz");
                    }
                };

        for (int num = 1; num <= n; num++) {
            StringBuilder numAnsStr = new StringBuilder();

            for (Integer key : fizzBizzDict.keySet()) {

                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr.append(fizzBizzDict.get(key));
                }
            }

            if (numAnsStr.toString().equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr.append(Integer.toString(num));
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr.toString());
        }

        return ans;
    }
}
