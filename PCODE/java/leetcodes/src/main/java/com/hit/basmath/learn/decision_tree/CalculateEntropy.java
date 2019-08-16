package com.hit.basmath.learn.decision_tree;

import java.util.ArrayList;
import java.util.List;

/***
 * Calculate Entropy

 * Given a group of values, the entropy of the group is defined as the formula as following:
 * <p>
 * where P(x) is the probability of appearance for the value x.
 * <p>
 * The exercise is to calculate the entropy of a group. Here is one example.
 * <p>
 * the input group:  [1, 1, 2, 2]
 * <p>
 * the probability of value 1 is  2/4 = 1/2
 * the probability of value 2 is  2/4 = 1/2
 * <p>
 * As a result, its entropy can be obtained by:  - (1/2) * log2(1/2) - (1/2) * log2(1/2) = 1/2 + 1/2 = 1
 * <p>
 * Note: the precision of result would remain within 1e^-6.
 */
public class CalculateEntropy {
    public double calculateEntropy(int[] input) {
        double entropy = 0.0;
        double probability;

        List<Integer> tempList = new ArrayList<>();

        for (int tempValue : input) {
            if (!tempList.contains(tempValue)) {
                tempList.add(tempValue);
                double numCount = 0.0;
                for (int anInput : input) {
                    if (tempValue == anInput) {
                        numCount++;
                    }
                }

                probability = numCount / input.length;
                entropy += (-probability * (Math.log(probability) / Math.log(2)));
            }
        }

        return entropy;
    }

    public static void main(String[] args) {
        int[] in = {1, 1, 2, 2};
        System.out.println((new CalculateEntropy()).calculateEntropy(in));
    }
}