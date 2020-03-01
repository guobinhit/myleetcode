package com.hit.basmath.interview.top_interview_questions.medium_collection.others;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 * <p>
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Example:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * Note:
 * <p>
 * 1. The number of tasks is in the range [1, 10000].
 * 2. The integer n is in the range [0, 100].
 */
public class _621 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) map[c - 'A']++;
        Arrays.sort(map);
        int maxVal = map[25] - 1, idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idleSlots -= Math.min(map[i], maxVal);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
