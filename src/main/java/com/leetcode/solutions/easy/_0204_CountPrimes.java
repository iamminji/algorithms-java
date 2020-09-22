package com.leetcode.solutions.easy;

public class _0204_CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n + 1];

        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                count++;
            }
            for (int j = 2; j * i < n; j++) {
                if (i * j > n) {
                    continue;
                }
                primes[i * j] = true;
            }

        }
        return count;
    }
}
