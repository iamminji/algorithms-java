package com.leetcode.solutions.medium;

import java.util.*;

// 1538 ms & 40.3 MB
public class _0621_TaskScheduler_01 {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char task : tasks) {
            counter.put(task, counter.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Character> queue =
                new PriorityQueue<>((c1, c2) -> counter.get(c2) - counter.get(c1));
        queue.addAll(counter.keySet());

        HashMap<Character, Integer> coolDown = new HashMap<>();
        int time = 0;


        while (!queue.isEmpty()) {
            List<Character> temp = new LinkedList<>();
            char task = queue.poll();
            temp.add(task);
            boolean doWork = false;
            // task 를 넣을 수 있는 차례가 된 경우
            if (!coolDown.containsKey(task) || time - coolDown.getOrDefault(task, 0) > n) {
                coolDown.put(task, time++);
                counter.put(task, counter.get(task) - 1);
                doWork = true;
            } else {
                while (!queue.isEmpty()) {
                    char t = queue.poll();
                    temp.add(t);
                    if (!coolDown.containsKey(t) || time - coolDown.getOrDefault(t, 0) > n) {
                        doWork = true;
                        coolDown.put(t, time++);
                        counter.put(t, counter.get(t) - 1);
                        break;
                    }
                }
            }
            // idle 시간 계산
            if (!doWork) {
                time++;
            }
            for (char t : temp) {
                if (counter.get(t) > 0) {
                    queue.add(t);
                }
            }
        }
        return time;
    }
    public static void main(String[] args) {
        _0621_TaskScheduler_01 main = new _0621_TaskScheduler_01();
        // 8
        System.out.println(main.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        // 16
        System.out.println(main.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
        // 15
        System.out.println(main.leastInterval(new char[]{'F', 'J', 'J', 'A', 'J', 'F', 'C', 'H', 'J', 'B', 'E', 'G', 'G', 'F', 'A'}, 2));
    }
}
