package com.leetcode.solutions.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Time Complexity O(N^3)
 * Space Complexity O(1)
 * <p>
 * 23M
 */
public class _0005_LongestPalindromicSubstring_01 {
    public boolean isValidPalindrome(String s, int i, int j) {

        boolean result = true;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                result = false;
                break;
            }
            i++;
            j--;
        }
        return result;
    }

    public String dfs(String s, int i, int j) {

        if (i > j) {
            return "";
        }

        if (isValidPalindrome(s, i, j)) {
            return s.substring(i, j + 1);
        }
        return dfs(s, i, j - 1);
    }

    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = dfs(s, i, s.length() - 1);
            if (temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0005_LongestPalindromicSubstring_01 solution = new _0005_LongestPalindromicSubstring_01();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
