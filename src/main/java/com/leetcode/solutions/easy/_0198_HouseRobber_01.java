package com.leetcode.solutions.easy;


/**
 * Try 2
 *  nums input 값의 범위를 제대로 확인 하지 않았다.
 */
public class _0198_HouseRobber_01 {
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int result = dp[1];

        for (int i = 2; i< nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
