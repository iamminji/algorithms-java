package com.leetcode.solutions.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * <p>
 * 60M
 */
public class _0003_LongestSubstringWithoutRepeatingCharacters_02 {
    public int lengthOfLongestSubstring(String s) {
        int result = 1;

        if (s.length() <= 1) {
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 1;
        map.put(s.charAt(i), i);
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
            j += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        _0003_LongestSubstringWithoutRepeatingCharacters_02 solution = new _0003_LongestSubstringWithoutRepeatingCharacters_02();
        System.out.println(solution.lengthOfLongestSubstring("abcdsddfdsfweqweqwekjklvf"));
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
    }
}
