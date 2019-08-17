package com.hit.basmath.interview.top_interview_questions.hard_collection.design;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 295. Find Median from Data Stream
 * <p>
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * For example,
 * [2,3,4], the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * Example:
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * Follow up:
 * <p>
 * 1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * 2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class _295 {

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    class MedianFinder {

        @SuppressWarnings("all")
        private Queue<Long> small = new PriorityQueue(), large = new PriorityQueue();

        public void addNum(int num) {
            large.add((long) num);
            small.add(-large.poll());
            if (large.size() < small.size())
                large.add(-small.poll());
        }

        public double findMedian() {
            return large.size() > small.size()
                    ? large.peek()
                    : (large.peek() - small.peek()) / 2.0;
        }
    }
}
