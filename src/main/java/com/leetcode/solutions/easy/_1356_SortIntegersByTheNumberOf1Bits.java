package com.leetcode.solutions.easy;

import java.util.Arrays;

// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/submissions/
public class _1356_SortIntegersByTheNumberOf1Bits {

    public int countBits(int n) {
        int result = 0;
        while (n != 0) {
            result += (n & 1) == 1 ? 1 : 0;
            n >>>= 1;
        }
        return result;
    }

    public int[] sortByBits(int[] arr) {
        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (o1, o2) -> {
            // 같을 때는 값 크기 대로
            if (countBits(o1) == countBits(o2)) {
                return o1 - o2;
            }
            // 오름 차순
            return countBits(o1) - countBits(o2);
        });
        return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        _1356_SortIntegersByTheNumberOf1Bits main = new _1356_SortIntegersByTheNumberOf1Bits();
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] actual = main.sortByBits(arr);
        System.out.println(Arrays.toString(actual));
    }
}
