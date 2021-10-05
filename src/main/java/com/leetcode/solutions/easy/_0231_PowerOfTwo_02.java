package com.leetcode.solutions.easy;

// https://leetcode.com/problems/power-of-two/
public class _0231_PowerOfTwo_02 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // n & (n-1) 은 가장 하위의 1을 지우는 것과 같다.
        // 2진승이라면 1의 개수는 하나이고 이 값을 지우면 0과 같다.
        // 따라서 n & (n-1) 이 0 이라면 이 값은 Power Of Two 이다.
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        _0231_PowerOfTwo_02 main = new _0231_PowerOfTwo_02();
        System.out.println(main.isPowerOfTwo(8));
        System.out.println(main.isPowerOfTwo(3));
    }
}
