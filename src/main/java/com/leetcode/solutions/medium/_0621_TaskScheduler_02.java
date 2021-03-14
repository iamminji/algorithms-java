package com.leetcode.solutions.medium;

import java.util.*;

// 20 ms & 40 MB
public class _0621_TaskScheduler_02 {

    public boolean isEmpty(int[] counter) {
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public int leastInterval(char[] tasks, int n) {

        int[] counter = new int[26];
        for (char t : tasks) {
            counter[t - 'A'] += 1;
        }

        PriorityQueue<Integer> queue =
                new PriorityQueue<>((c1, c2) -> counter[c2] - counter[c1]);

        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) {
                queue.add(i);
            }
        }

        int time = 0;
        while (!isEmpty(counter)) {
            int i = 0;
            // i 가 n 이 될 때까지 큐에 있는 모든 task 를 다 사용한다는 의미
            while (i <= n && !isEmpty(counter)) {
                if (!queue.isEmpty()) {
                    int task = queue.poll();
                    counter[task] -= 1;
                }
                i++;
                time++;
            }
            // queue 초기화
            // PriorityQueue 다시 사용하려고
            queue.clear();
            for (int j = 0; j < 26; j++) {
                if (counter[j] > 0) {
                    queue.add(j);
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        _0621_TaskScheduler_02 main = new _0621_TaskScheduler_02();
        // 8
        System.out.println(main.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        // 16
        System.out.println(main.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
        // 15
        System.out.println(main.leastInterval(new char[]{'F', 'J', 'J', 'A', 'J', 'F', 'C', 'H', 'J', 'B', 'E', 'G', 'G', 'F', 'A'}, 2));
    }
}
