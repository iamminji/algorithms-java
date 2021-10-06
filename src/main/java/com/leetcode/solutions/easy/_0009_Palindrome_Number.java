package com.leetcode.solutions.easy;

// https://leetcode.com/problems/palindrome-number/
public class _0009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        // 2자리 수는 무조건 false 이다.
        // 단 x 가 0일 때도 값이 0이 나와서 이 부분만 예외처리 한다.
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int size = 0;
        int num = x;
        while (num >= 1) {
            size++;
            num /= 10;
        }

        int mask = (int) Math.pow(10, size - 1);
        for (int i = 0; i < (size / 2); i++) {
            int a = x / mask;
            int b = x % 10;
            if (a != b) {
                return false;
            }
            // 최상위 숫자를 삭제한다.
            x %= mask;
            // 최하위 숫자를 삭제한다.
            x /= 10;
            // 최상위, 최하위 비트를 삭제하였기 때문에 100 으로 나누어준다. (자릿수가 숫자 2개만큼 줄어듦)
            mask /= 100;

        }
        return true;
    }

    public static void main(String[] args) {
        _0009_Palindrome_Number main = new _0009_Palindrome_Number();
        System.out.println(main.isPalindrome(0));
        System.out.println(main.isPalindrome(1));
        System.out.println(main.isPalindrome(10));
        System.out.println(main.isPalindrome(-101));
        System.out.println(main.isPalindrome(101));
        System.out.println(main.isPalindrome(202));
        System.out.println(main.isPalindrome(10001));
        System.out.println(main.isPalindrome(12321));
        System.out.println(main.isPalindrome(10010));
    }
}
