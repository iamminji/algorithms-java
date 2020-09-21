package com.leetcode.solutions.easy;


/**
 * https://leetcode.com/problems/maximum-subarray/
 * <p>
 * Time Complexity O(N^2)
 * Space Complexity O(N)
 * 15M (Try 3) - 최솟 값 자료 구조 형 오류로 인해서
 */
public class _0053_MaximumSubarray_01 {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int[] cur = new int[nums.length];
            for (int k = 0; k < nums.length; k++) {
                cur[k] = Integer.MIN_VALUE;
            }

            cur[i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                cur[j] = cur[j - 1] + nums[j];
            }
            for (int num : cur) {
                sum = Math.max(sum, num);
            }
        }
        return sum;
    }
}
