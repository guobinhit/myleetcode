package com.hit.math.decision_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculate Maximum Information Gain
 * <p>
 * Definitions
 * Given a group of values, the entropy of the group is defined as the formula as following:
 * <p>
 * where P(x) is the probability of appearance for the value x.
 * <p>
 * e.g.
 * <p>
 * the input group:  [1, 1, 2, 2]
 * <p>
 * the probability of value 1 is:  2/4 = 1/2
 * the probability of value 2 is:  2/4 = 1/2
 * <p>
 * Therefore, its entropy can be obtained by:  - (1/2) * log2(1/2) - (1/2) * log2(1/2) = 1/2 + 1/2 = 1
 * <p>
 * This exercise, however, is aimed to calculate the maximum information gain that one can obtain by splitting a group into two subgroups. The information gain is the difference of entropy before and after the splitting.
 * <p>
 * For a group of L, we divide it into subgroups of {L1, L2}, then the information gain is calculated as following:
 * <p>
 * The overall entropy of the splitted subgroups {L1, L2} is the sum of entropy for each subgroup weighted by its proportion with regards to the original group.
 * <p>
 * Problem Description
 * In this exercise, one can expect a list of samples on Iris flowers. Each sample is represented with a tuple of two values: <petal_length, species>, where the first attribute is the measurement on the length of the petal for the sample, and the second attribute indicates the species of sample. Here is an example.
 * <p>
 * The task is to split the sample list into two sublists, while complying with the following two conditions:
 * <p>
 * The petal_length of sample in one sublist is less or equal than that of any sample in the other sublist.
 * The information gain on the species attribute of the sublists is maximal among all possible splits.
 * As output, one should just return the information gain.
 * <p>
 * In addition, one can expect that each value of petal_length is unique.
 * <p>
 * In the above example, the optimal split would be L1 = [(0.5, 'setosa'), (1.0, 'setosa')] and L2 = [(1.5, 'versicolor'), (2.3, 'versicolor')]. According the above formulas, the maximum information gain for this example would be 1.0.
 * <p>
 * Note:  For certain languages (e.g. Java), there is no build-in type of tuple. As a reuslt, to make the input more general, we decompose the input into two lists: [petal_length] [species] respectively, where the petal_length would be of float value and the species is of string. The elements in the petal_length list and species list are associated to each other one by one by order.
 */
public class CalculateMaxInfoGain {
    public double calculateMaxInfoGain(List<Double> petal_length, List<String> species) {

        List<Double> setosaList = new ArrayList<>();
        List<Double> versicolorList = new ArrayList<>();

        for (int i = 0; i < species.size(); i++) {
            if ("setosa".equals(species.get(i))) {
                setosaList.add(petal_length.get(i));
            } else {
                versicolorList.add(petal_length.get(i));
            }
        }

        double[] setosaPetalLenghtArray = new double[setosaList.size()];
        double[] versicolorPetalLenghtArray = new double[versicolorList.size()];
        double[] speciesPetalLenghtArray = new double[species.size()];

        for (int i = 0; i < setosaList.size(); i++) {
            setosaPetalLenghtArray[i] = setosaList.get(i);
        }

        for (int i = 0; i < versicolorList.size(); i++) {
            versicolorPetalLenghtArray[i] = versicolorList.get(i);
        }

        for (int i = 0; i < petal_length.size(); i++) {
            speciesPetalLenghtArray[i] = petal_length.get(i);
        }

        double infoGain;

        infoGain = calculateEntropy(speciesPetalLenghtArray)
                - calculateEntropy(setosaPetalLenghtArray) * (setosaPetalLenghtArray.length / speciesPetalLenghtArray.length)
                - calculateEntropy(versicolorPetalLenghtArray) * (versicolorPetalLenghtArray.length / speciesPetalLenghtArray.length);

        return infoGain;
    }

    private double calculateEntropy(double[] input) {
        double entropy = 0.0;
        double probability;

        List<Double> tempList = new ArrayList<>();

        for (double tempValue : input) {
            if (!tempList.contains(tempValue)) {
                tempList.add(tempValue);
                double numCount = 0.0;
                for (double anInput : input) {
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
}
