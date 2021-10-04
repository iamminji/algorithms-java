package com.leetcode.solutions.easy;

// https://leetcode.com/problems/reverse-bits/
public class _0190_ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            if (i < 31) {
                // 가장 마지막 iteration 일 때 비트가 밀려나기 때문
                result <<= 1;
            }
            n >>= 1;
        }
        return result;
    }
}
