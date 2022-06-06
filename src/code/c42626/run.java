package code.c42626;


import java.util.Iterator;
import java.util.PriorityQueue;


public class run {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        //
        int answer = 0;
        PriorityQueue<Integer> foods = new PriorityQueue<>();

        for (int i : scoville) {
            foods.add(i);
        }

        while (true) {
            if (foods.size() == 1 && foods.iterator().next() < K) {
                answer = -1;
                break;
            } else if (foods.iterator().next() >= K) {
                break;
            }

            Integer food1 = foods.poll();
            Integer food2 = foods.poll();
            int newFood = food1 + food2 * 2;

            foods.add(newFood);

            answer++;
        }


        System.out.println("answer = " + answer);

        // 모든 음식의 스코빌 지수를 K이상으로 만들거나
        // 모든 음식의 스코빌 지수를 K이상으로 못만들거나 -> 최종 남은 1개가 k가 안되면


        // 제일 낮은 숫자와, 그 다음 낮은 숫자를 조합하는 것을 반복
        // 제일 낮은 숫자를 계속 판별해야 하므로 TreeSet 사용

        // 문제점:
        // 중복이 나오는데 set 사용
        // 속도가 느림



    }




}
