package com.leetcode.solutions.easy;

import java.util.Stack;

public class _0007_ReverseInteger_01 {
    public int reverse(int x) {

        Stack<Integer> stack = new Stack<>();

        while (x != 0) {
            int p = x % 10;
            stack.push(p);
            x /= 10;
        }

        long result = 0;
        long q = 1;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            result = result + num * q;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            q *= 10;
        }
        return (int) result;
    }
}
