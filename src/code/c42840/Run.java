package code.c42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Run {

    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] write = new int[3];
        int[] correct = new int[3]; 

        int answerNum = 0;
        for (int answer : answers) {
            write[0] = student1[answerNum % (student1.length)];
            write[1] = student2[answerNum % (student2.length)];
            write[2] = student3[answerNum % (student3.length)];

            for (int i = 0; i < 3; i++) {
                if (write[i] == answer) {
                    correct[i]++;
                }                
            }            
            answerNum++;
        }

        int maxScore = 0;
        maxScore = Math.max(correct[0], correct[1]);
        maxScore = Math.max(maxScore, correct[2]);

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (correct[i] == maxScore) {
                answerList.add(i+1);
            }
        }

        int[] answer = answerList.stream().mapToInt(i -> i).toArray();



    }
}
