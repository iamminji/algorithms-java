package com.leetcode.solutions.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 * <p>
 * 10M
 */
public class _0003_LongestSubstringWithoutRepeatingCharacters_01 {
    public int lengthOfLongestSubstring(String s) {
        int result = 1;

        if (s.length() <= 1) {
            return s.length();
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    set.clear();
                    break;
                }
                result = Math.max(result, j - i + 1);
                set.add(s.charAt(j));
            }
        }
        return result;
    }
}
