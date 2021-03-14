package com.leetcode.solutions.medium;

import java.util.*;

// Try 1 TLE
// Try 2 8 ms (Sliding Window)
public class _0438_FindAllAnagramsInAString {

    public boolean match(int[] sc, int[] pc) {
        for (int i = 0; i < 26; i++) {
            if (sc[i] != pc[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pc = new int[26];
        int[] sc = new int[26];

        for (int i = 0; i < p.length(); i++) {
            // counter
            pc[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (right - left == p.length() - 1) {
                sc[s.charAt(right++) - 'a']++;
            } else {
                while (right - left < p.length()) {
                    sc[s.charAt(right++) - 'a']++;
                }
            }
            if (match(sc, pc)) {
                result.add(left);
            }
            sc[s.charAt(left++) - 'a']--;
        }
        return result;
    }


    public static void main(String[] args) {
        _0438_FindAllAnagramsInAString main = new _0438_FindAllAnagramsInAString();
        System.out.println(main.findAnagrams("cbaebabacd", "abc"));
        System.out.println(main.findAnagrams("abab", "ab"));
        System.out.println(main.findAnagrams("aaaaaaaaa", "aa"));
        System.out.println(main.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));

    }
}
