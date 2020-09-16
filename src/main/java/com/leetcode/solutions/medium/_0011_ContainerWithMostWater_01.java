package com.leetcode.solutions.medium;

// 5M
public class _0011_ContainerWithMostWater_01 {
    public int maxArea(int[] height) {
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                result = Math.max(width * Math.min(height[i], height[j]), result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0011_ContainerWithMostWater_01 solution = new _0011_ContainerWithMostWater_01();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
