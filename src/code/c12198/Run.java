package code.c12198;

import java.util.*;

public class Run {


    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

       // int[] array = {1, 5, 2, 6, 3, 7, 4};
       // int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}, {1,7,3}};


        List<Integer> answerList = new ArrayList<>();
        for (int s = 0; s < commands.length; s++) {
            int cutFrom = commands[s][0];
            int cutTo = commands[s][1];
            int findIndex = commands[s][2];

            TreeSet<Integer> treeSet = new TreeSet();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = cutFrom - 1; i < cutTo; i++) {
                treeSet.add(array[i]);
                queue.add(array[i]);
            }


            Iterator iter = treeSet.iterator();
            Iterator<Integer> iter2 = queue.iterator();
            for (int i = 0; i < findIndex-1; i++) {
                iter.next();
                queue.poll();
            }
            //answerList.add((Integer) iter.next());
            answerList.add((Integer) queue.poll());
        }


        int[] answer = answerList.stream().mapToInt(i->i).toArray();

    }
}
