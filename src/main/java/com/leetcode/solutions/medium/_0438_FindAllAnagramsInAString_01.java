package com.leetcode.solutions.medium;

import java.util.*;

// Try 1 TLE
public class _0438_FindAllAnagramsInAString_01 {

    public boolean isMatch(HashMap<Character, Integer> counter) {
        for (char key : counter.keySet()) {
            if (counter.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pCounter = new HashMap<>();
        List<Integer> result = new LinkedList<>();

        if (s.length() < p.length()) {
            return result;
        }

        for (int idx = 0; idx < p.length(); idx++) {
            pCounter.put(p.charAt(idx), pCounter.getOrDefault(p.charAt(idx), 0) + 1);
        }

        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length()) {
                if (pCounter.containsKey(s.charAt(j)) && pCounter.get(s.charAt(j)) > 0) {
                    pCounter.put(s.charAt(j), pCounter.get(s.charAt(j)) - 1);
                    j++;
                } else {
                    break;
                }
            }
            if (isMatch(pCounter)) {
                result.add(i);
            }
            i++;
            pCounter.clear();
            for (int idx = 0; idx < p.length(); idx++) {
                pCounter.put(p.charAt(idx), pCounter.getOrDefault(p.charAt(idx), 0) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0438_FindAllAnagramsInAString_01 main = new _0438_FindAllAnagramsInAString_01();
        System.out.println(main.findAnagrams("cbaebabacd", "abc"));
        System.out.println(main.findAnagrams("abab", "ab"));
        System.out.println(main.findAnagrams("aaaaaaaaa", "aa"));
        System.out.println(main.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));

    }
}
