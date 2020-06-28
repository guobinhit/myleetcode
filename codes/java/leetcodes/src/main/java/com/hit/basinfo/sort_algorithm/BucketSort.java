package com.hit.basinfo.sort_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * author:Charies Gavin
 * date:2020/6/22,8:55
 * https:github.com/guobinhit
 * description: Bucket Sort
 */
public class BucketSort {
    public void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // create bucket
        int bucketNum = (max - min) / nums.length + 1;
        List<List<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }
        // put element into bucket
        for (int num : nums) {
            int n = (num - min) / nums.length;
            bucketArr.get(n).add(num);
        }
        // sort every bucket
        int index = 0;
        for (List<Integer> aBucketArr : bucketArr) {
            Collections.sort(aBucketArr);
            for (Integer integer : aBucketArr) {
                if (Objects.nonNull(integer)) {
                    nums[index] = integer;
                    index++;
                }
            }
        }
    }
}
