package com.leetcode.easy;

import java.util.*;

/**
 * 0001. https://leetcode.com/problems/two-sum/
 * Input size 2 <= nums.length <= 10^5
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _0001_TwoSum_02 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val) && i != map.get(val)) {
                return new int[]{i, map.get(val)};
            }
        }

        return result;
    }
}
