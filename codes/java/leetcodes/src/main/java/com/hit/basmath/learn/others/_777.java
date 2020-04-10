package com.hit.basmath.learn.others;

/**
 * 777. Swap Adjacent in LR String
 * <p>
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 * <p>
 * Example:
 * <p>
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * Note:
 * <p>
 * 1. 1 <= len(start) = len(end) <= 10000.
 * 2. Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class _777 {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int p1 = 0;
        int p2 = 0;

        while (p1 < start.length() && p2 < end.length()) {

            // get the non-X positions of 2 strings
            while (p1 < start.length() && start.charAt(p1) == 'X') {
                p1++;
            }
            while (p2 < end.length() && end.charAt(p2) == 'X') {
                p2++;
            }

            //if both of the pointers reach the end the strings are transformable
            if (p1 == start.length() && p2 == end.length()) {
                return true;
            }
            // if only one of the pointer reach the end they are not transformable
            if (p1 == start.length() || p2 == end.length()) {
                return false;
            }

            if (start.charAt(p1) != end.charAt(p2)) {
                return false;
            }
            // if the character is 'L', it can only be moved to the left. p1 should be greater or equal to p2.
            if (start.charAt(p1) == 'L' && p2 > p1) {
                return false;
            }
            // if the character is 'R', it can only be moved to the right. p2 should be greater or equal to p1.
            if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }
}
