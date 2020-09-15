package com.leetcode.solutions.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Time Complexity O(N^3)
 * Space Complexity O(1)
 * <p>
 * 10M
 */
public class _0005_LongestPalindromicSubstring_02 {

    public boolean isValidPalindrome(String s, int i, int j) {

        if (i > j) {
            return false;
        }

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isValidPalindrome(s, i, j)) {
                    if (res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0005_LongestPalindromicSubstring_02 solution = new _0005_LongestPalindromicSubstring_02();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("abacab"));
    }
}
