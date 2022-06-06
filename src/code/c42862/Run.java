package code.c42862;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Run {

    public static void main(String[] args) {
        int n = 10;
        int[] lost = {2,4,6};
        int[] reserve = {1,3};

        // 자료형 저장
        Set<Integer> reserveSet = new CopyOnWriteArraySet<>();
        Set<Integer> lostSet = new CopyOnWriteArraySet<>();

        for (int i : reserve) {
            reserveSet.add(i);
        }
        for (int i : lost) {
            if (reserveSet.contains(i)) {
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }

        }

        // 빌릴 수 있는 유일 한 경우라면 먼저 빌리는 것을 반복
        while(true) {
            boolean isEnd = true;
            for (Integer lostNum : lostSet) {
                boolean isHasPre = reserveSet.contains(lostNum - 1);
                boolean isHasNext = reserveSet.contains(lostNum + 1);
                if ((isHasPre && isHasNext) || !(isHasPre || isHasNext)) {
                    continue;
                }
                isEnd = false;
                int rentalNum = 0;
                if (isHasPre) {
                    rentalNum = lostNum - 1;
                } else if (isHasNext) {
                    rentalNum = lostNum + 1;
                }
                lostSet.remove(lostNum);
                reserveSet.remove(rentalNum);
            }

            if (isEnd) {
                break;
            }

        }


        // 양쪽에서 빌릴 수 있는 경우
        for (Integer lostNum : lostSet) {
            boolean isHasPre = reserveSet.contains(lostNum - 1);
            boolean isHasNext = reserveSet.contains(lostNum + 1);
            if ( isHasPre && isHasNext) {
                lostSet.remove(lostNum);
            }
        }

        System.out.println("lostSet = " + lostSet);
        System.out.println("reserveSet = " + reserveSet);

        int answer = n - lostSet.size();
        System.out.println("answer = " + answer);
        //return answer;

    }
}
