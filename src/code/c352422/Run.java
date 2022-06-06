package code.c352422;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Run {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        List<Integer> answerList = new ArrayList<>();

        int curNum = -1;
        for (int i : arr) {
            if (curNum != i) {
                answerList.add(i);
                curNum = i;
            }
        }

        int[] answer = Arrays.stream(answerList.toArray(new Integer[answerList.size()])).mapToInt(i->i).toArray();


    }
}
