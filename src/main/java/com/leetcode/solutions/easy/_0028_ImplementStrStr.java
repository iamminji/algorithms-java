package com.leetcode.solutions.easy;


/**
 * Try 5
 * TLE 때문에 에러가 많이 남
 */
public class _0028_ImplementStrStr {
    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }


        if (haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {

            // TLE 를 줄이기 위한 코드
            // haystack 의 참조 시작 인덱스와 needle 을 더해서 나온 값이 haystack 보다 크면 계산하지 않아도 된다.
            // 그 이유는 needle 은 haystack 보다 길이가 늘 작거나 같아야 하기 때문이다.
            if (i + needle.length() > haystack.length()) {
                break;
            }
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    break;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _0028_ImplementStrStr solution = new _0028_ImplementStrStr();
        System.out.println(solution.strStr("aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaab"));
    }
}
