package com.leetcode.solutions.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/solution/
 * Time Complexity O(N)
 * Space Complexity O(1)
 * 5M (Try 1)
 */
public class _0020_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c2 = stack.pop();
                if (c == ')' && c2 != '(') {
                    return false;
                }
                if (c == ']' && c2 != '[') {
                    return false;
                }
                if (c == '}' && c2 != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
