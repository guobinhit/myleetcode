package com.hit.basmath.interview.we_meet.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit 1
 * @date 2020/3/6,上午11:37
 * @description
 */
public class Top100 {
    public static void main(String[] args) {
        Top100 top100 = new Top100();
        List<Integer> list = new ArrayList<>();
        System.out.println(top100.getTopK(list, 100));
    }

    private List<Integer> getTopK(List<Integer> billion, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer i : billion) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.addAll(minHeap);
        return ans;
    }
}
