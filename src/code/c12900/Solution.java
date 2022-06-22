package code.c12900;

public class Solution {

    public int solution(int n) {
        int answer = 0;

        // 1 - 1
        // 2 - 2
        // 3 - 3
        // 4 - 1111(1) 112(3) 22(1) - 5
        // 5 - 11111(1) 1112(4) 122(3) - 8
        // 6 - 111111(1) 11112(5) 1122(6) 222(1) - 13
        // 피보나치네

        long record[] = new long[60001];

        record[1] = 1;
        record[2] = 2;
        record[3] = 3;

        for (int i = 4; i <= n; i++) {
            record[i] = (record[i-1] + record[i-2]) % 1000000007 ;
        }

        return (int)record[n];
    }


    public static void main(String[] args) {
        int solution = new Solution().solution(4);
        System.out.println("solution = " + solution);
    }
}
