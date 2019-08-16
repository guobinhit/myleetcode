package com.hit.basmath.learn.queue_stack;

import java.util.*;

/**
 * 752. Open the Lock
 * <p>
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * <p>
 * Example 1:
 * <p>
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * <p>
 * Output: 6
 * <p>
 * Explanation:
 * <p>
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * <p>
 * Example 2:
 * <p>
 * Input: deadends = ["8888"], target = "0009"
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * <p>
 * Example 3:
 * <p>
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * <p>
 * Output: -1
 * <p>
 * Explanation:
 * <p>
 * We can't reach the target without getting stuck.
 * <p>
 * Example 4:
 * <p>
 * Input: deadends = ["0000"], target = "8888"
 * <p>
 * Output: -1
 * <p>
 * Note:
 * <p>
 * The length of deadends will be in the range [1, 500].
 * target will not be in the list deadends.
 * Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 */
public class _752 {
    public static int openLock(String[] deadends, String target) {
        Queue<String> aimQueue = new LinkedList<String>();
        Set<String> deads = new HashSet<String>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<String>();
        aimQueue.offer("0000");
        visited.add("0000");
        int level = 0;
        while (!aimQueue.isEmpty()) {
            int size = aimQueue.size();
            while (size > 0) {
                String s = aimQueue.poll();
                if (deads.contains(s)) {
                    size--;
                    continue;
                }
                if (s.equals(target)) {
                    return level;
                }
                StringBuilder sb = new StringBuilder(s);
                /**
                 * This loop is in order to ergodic every possible results in 1 step
                 * for example, initial element is 0000, there have 8 possible results
                 * 1000、9000、0100、0900、0010、0090、0001、0009
                 */
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!visited.contains(s1) && !deads.contains(s1)) {
                        aimQueue.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deads.contains(s2)) {
                        aimQueue.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    /**
     * Runtime: 85ms
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock2(String[] deadends, String target) {
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        Set<String> deads = new HashSet<String>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        while (!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<String>();
            for (String s : begin) {
                if (end.contains(s)) return level;
                if (deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!deads.contains(s1))
                        temp.add(s1);
                    if (!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level++;
            begin = end;
            end = temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        String[] deadends2 = {"8888"};
        String target2 = "0009";

        String[] deadends3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target3 = "8888";

        String[] deadends4 = {"0000"};
        String target4 = "8888";

        System.out.println(_752.openLock(deadends, target));
        System.out.println(_752.openLock(deadends2, target2));
        System.out.println(_752.openLock(deadends3, target3));
        System.out.println(_752.openLock(deadends4, target4));
    }
}
