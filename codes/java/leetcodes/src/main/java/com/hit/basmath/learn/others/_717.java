package com.hit.basmath.learn.others;

/**
 * 717. 1-bit and 2-bit Characters
 * <p>
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * <p>
 * Note:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 */
public class _717 {
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        //Starting from one but last, as last one is always 0.
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
            ones++;
        }
        if (ones % 2 > 0) return false;
        return true;
    }
}
