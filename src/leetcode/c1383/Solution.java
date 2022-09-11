package leetcode.c1383;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Person[] person = new Person[n];
        for (int i = 0; i < n; i++) {
            person[i] = new Person(speed[i], efficiency[i]);
        }

        Arrays.sort(person, Comparator.comparing(p -> p.speed * -1));
        //스피드는 무조건 낮으니까 효율이 높아 질 수 있는 것 만이 대상임 -> 효율이 제일 낮은 애가 빠져야함?
        PriorityQueue<Person> queue = new PriorityQueue<>(Comparator.comparing(p -> p.efficiency));
        int sum = 0;
        queue.add(person[0]);
        sum += person[0].speed;
        for (int i = 1; i < n; i++) {
            if (queue.peek().efficiency > person[i].efficiency && queue.size() == k) {
                continue;
            }
            Person poll = queue.poll();
            int minEfficiency = person[i].efficiency;
            if (!queue.isEmpty()) {
                minEfficiency = queue.peek().efficiency < person[i].efficiency ? queue.peek().efficiency : person[i].efficiency;
            }
            int a = (sum * poll.efficiency) % 1000000007; //안넣기
            int b = ((sum - poll.speed + person[i].speed) * minEfficiency) % 1000000007; //하나빼고넣기
            int c = 0; //넣기만하기
            if (queue.size() != k - 1) {
                int e = poll.efficiency < minEfficiency ? poll.efficiency : minEfficiency;
                c = ((sum + person[i].speed) * e) % 1000000007;
            }

            if (a < b && c < b) {
                //queue.poll();
                queue.add(person[i]);
                sum = sum - poll.speed + person[i].speed;
            } else if (b < a && c < a) {
                queue.add(poll);
            } else {
                queue.add(poll);
                queue.add(person[i]);
                sum = sum + person[i].speed;
            }

        }

        // int result = (sum * queue.peek().efficiency) % 1000000007;
        int e = queue.peek().efficiency;
        int result = 0;
        for (Person person1 : queue) {
            for (int i = 0; i < e; i++) {
                result += person1.speed % 1000000007;
                result %= 1000000007;
            }
        }
        return result;
    }

    public class Person {
        int speed;
        int efficiency;

        public Person(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPerformance(4,
                new int[]{8,9,5,9},
                new int[]{1,2,6,9}, 2)); // 84
        System.out.println(new Solution().maxPerformance(3,
                new int[]{9,9,9},
                new int[]{1,4,10}, 2)); // 90
        System.out.println(new Solution().maxPerformance(5,
                new int[]{10,10,7,9,8},
                new int[]{9,8,3,6,9}, 1)); // 90
        System.out.println(new Solution().maxPerformance(3,
                new int[]{2, 8, 2},
                new int[]{2, 7, 1}, 2)); // 56
        System.out.println(new Solution().maxPerformance(6,
                new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5, 4, 3, 9, 7, 2}, 4)); // 72
    }
}
