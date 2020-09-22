package com.leetcode.solutions.easy;

public class _0007_ReverseInteger_02 {
    public int reverse(int x) {

        long result = 0;
        while (x != 0) {
            int p = x % 10;
            result = result * 10 + p;
            x /= 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }
}
