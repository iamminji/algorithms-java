package com.leetcode.solutions.medium;

public class _0011_ContainerWithMostWater_02 {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            result = Math.max(Math.min(height[left], height[right]) * (right - left), result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _0011_ContainerWithMostWater_02 solution = new _0011_ContainerWithMostWater_02();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{8, 2, 3, 4, 10, 1, 2, 8}));
    }
}
