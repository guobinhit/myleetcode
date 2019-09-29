package com.hit.basmath.learn.others;

/**
 * 551. Student Attendance Record I
 * <p>
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * <p>
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * <p>
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * <p>
 * Input: "PPALLP"
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: "PPALLL"
 * Output: False
 */
public class _551 {
    public boolean checkRecord(String s) {
        return !(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"));
    }
}
