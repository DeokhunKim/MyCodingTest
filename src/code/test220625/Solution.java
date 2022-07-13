package code.test220625;

import java.util.*;

public class Solution {
    List<Integer> cardList = new ArrayList<>();
    public int[] solution(int[] cards, String[] shuffles) {

        for (int card : cards) {
            cardList.add(card);
        }

        for (String shuffle : shuffles) {
            if (shuffle.equals("Cut")) {
                cut();
            } else {
                riffle();
            }
        }
        int[] answer = cardList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public void cut() {
        List<Integer> newCard = new ArrayList<>();
        newCard.addAll(cardList.subList(cardList.size()/2, cardList.size()));
        newCard.addAll(cardList.subList(0, cardList.size()/2));
        cardList = newCard;
    }

    public void riffle() {
        List<Integer> newCard = new ArrayList<>();
        for (int i = 0; i < cardList.size() / 2; i++) {
            newCard.add(cardList.get(cardList.size() / 2 - i - 1));
            newCard.add(cardList.get(cardList.size() - i - 1));
        }
        Collections.reverse(newCard);
        cardList = newCard;
    }


    public static void main(String[] args) {
        int[] goods = {5, 2, 4, 6, 1, 3};
        String[] boxes = {"Riffle", "Riffle", "Riffle"};
        int[] solution = new Solution().solution(goods, boxes);
        System.out.println("solution = " + solution);


    }


}
