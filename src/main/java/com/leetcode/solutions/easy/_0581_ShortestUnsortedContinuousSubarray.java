package com.leetcode.solutions.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * Time Complexity O(NLogN)
 * Space Complexity O(N)
 * 5M (Try 2)
 */
public class _0581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] orgNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            orgNums[i] = nums[i];
        }
        Arrays.sort(nums);

        int left = 0;
        for (int i =0; i< nums.length;i++) {

            if (nums[i] != orgNums[i]) {
                left = i;
                break;
            }
        }

        int right = 0;
        for (int i = nums.length-1; i>=0; i--) {
            if (nums[i] != orgNums[i]) {
                right = i;
                break;
            }
        }

        if (left == right) {
            return 0;
        }
        return right - left + 1;

    }
}
