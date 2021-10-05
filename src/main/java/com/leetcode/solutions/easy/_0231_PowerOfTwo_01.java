package com.leetcode.solutions.easy;

// https://leetcode.com/problems/power-of-two/
// n 은 비트의 개수인데 32비트여서 32번으로 고정 되는 느낌..?
// Time Complexity O(n)
// Space Complexity O(1)
public class _0231_PowerOfTwo_01 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int r = 0;
        while (n != 0) {
            r += n & 1;
            // 1의 개수를 세서 1개 초과일 경우엔 2진승이 아니다.
            if (r > 1) {
                return false;
            }
            n >>>= 1;
        }
        return true;
    }
}
