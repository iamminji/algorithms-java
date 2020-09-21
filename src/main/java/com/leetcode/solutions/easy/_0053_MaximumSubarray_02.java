package com.leetcode.solutions.easy;

public class _0053_MaximumSubarray_02 {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            sum = Math.max(sum, cur);
        }
        return sum;
    }

}
