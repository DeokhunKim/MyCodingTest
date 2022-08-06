package leetcode.c458;

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round = minutesToTest / minutesToDie;
        int max = 1;
        int pig = 1;

        if (buckets == 1) {
            return 0;
        }

        while (true) {
            max *= (round + 1);

            if (max >= buckets) {
                return pig;
            } else {
                pig++;
            }
        }
    }

    public static void main(String[] args) {
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;

        int i = new Solution().poorPigs(buckets, minutesToDie, minutesToTest);
        System.out.println("i = " + i);

    }
}