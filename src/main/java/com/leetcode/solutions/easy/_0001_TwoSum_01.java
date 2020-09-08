package com.leetcode.solutions.easy;

/**
 * 0001. https://leetcode.com/problems/two-sum/
 * Input size 2 <= nums.length <= 10^5
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class _0001_TwoSum_01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return result;
    }
}
