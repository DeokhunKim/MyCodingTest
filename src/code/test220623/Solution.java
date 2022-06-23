package code.test220623;


import java.util.*;

public class Solution {

    public int solution(int[] goods, int[] boxes){
        int answer = 0;

        ArrayList<Integer> goodsQ = new ArrayList<>();
        ArrayList<Integer> boxesQ = new ArrayList<>();

        for (Integer integer : goods) {
            goodsQ.add(integer);
        }
        for (Integer integer : boxes) {
            boxesQ.add(integer);
        }

        //Collections.sort(goodsQ, Collections.reverseOrder());
        //Collections.sort(boxesQ, Collections.reverseOrder());


        Iterator<Integer> goodsIter = goodsQ.iterator();
        while (goodsIter.hasNext()) {
            int good = goodsIter.next();
            Iterator<Integer> boxesIter = boxesQ.iterator();
            while (boxesIter.hasNext()) {
                int box = boxesIter.next();
                if (good <= box) {
                    boxesIter.remove();
                    //goodsIter.remove();
                    answer++;
                    break;
                } else {
                    break;
                }

            }
        }


        return answer;
    }


    public static void main(String[] args) {
        int[] goods = {3, 8, 6};
        int[] boxes = {5, 6, 4};
        int solution = new Solution().solution(goods, boxes);
        System.out.println("solution = " + solution);


    }

}
