package com.leetcode.solutions.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * <p>
 * Brute Force 로 풀이
 * - Time Complexity: O(M+N)
 * - Space Complexity: O(M+N)
 * - 풀이 시간 15M
 * <p>
 * 문제 풀이 조건이 Time Complexity O(log(M+N)) 이였다.
 * Brute force 로 풀면 난이도가 easy 정도.
 */
public class _0004_MedianOfTwoSortedArrays_01 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int result = 0;

        int i = 0;
        int j = 0;

        if (nums1.length == 0 && nums2.length != 0) {
            return getMedianValue(nums2);
        } else if (nums2.length == 0 && nums1.length != 0) {
            return getMedianValue(nums1);
        }

        int size = nums1.length + nums2.length;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                temp.add(nums1[i++]);
            } else if (nums1[i] > nums2[j]) {
                temp.add(nums2[j++]);
            } else {
                temp.add(nums1[i++]);
                temp.add(nums2[j++]);
            }
        }

        while (i < nums1.length) {
            temp.add(nums1[i++]);
        }

        while (j < nums2.length) {
            temp.add(nums2[j++]);
        }

        if (size % 2 == 0) {
            return (temp.get(size / 2) + temp.get((size / 2) - 1)) / 2.0;
        }
        return (temp.get(size / 2));
    }

    public double getMedianValue(int[] nums) {
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[(nums.length / 2) - 1]) / 2.0;
        } else {
            return (nums[nums.length / 2]);
        }
    }
}
