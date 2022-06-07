package code.c42627;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        List<Work> works = new ArrayList<>();
        List<Work> waitList = new ArrayList<>();

        for (int[] job : jobs) {
            works.add(new Work(job));
        }

        for(int t = 0 ; ; t++) {
            if(works.size() == 0 && waitList.size() == 0) break;

            Iterator<Work> iterator = works.iterator();
            while (iterator.hasNext()) {
                Work w = iterator.next();
                if (w.isRequest(t)) {
                    waitList.add(w);
                    iterator.remove();
                }
            }

            if (waitList.size() == 0) {
                continue;
            }

            Work targetWork = null;
            double maxScore = -1 ;
            for (Work work : waitList) {
                if (maxScore < work.getScore_SJF(t)) {
                    maxScore = work.getScore_SJF(t);
                    targetWork = work;
                }
            }

            System.out.println("time:" + t + "/targetWork = " + targetWork.toString());
            t += targetWork.spend - 1;
            answer += targetWork.getEndTime(t+1);
            waitList.remove(targetWork);
        }

        answer = answer/jobs.length;
        System.out.println("answer = " + answer);

        return answer;
    }

    public class Work {
        int request;
        int spend;

        public Work(int[] job) {
            request = job[0];
            spend = job[1];
        }

        public boolean isRequest(int time) {
            if (request <= time) {
                return true;
            }
            return false;
        }

        public double getScore_SJF(int time) {
            return 1.0  / (spend + 0.0);
        }

        public double getScore_HRN(int time) {
            double i = (time - request + 0.0) / (spend + 1.0);
            return i;
        }

        public int getEndTime(int time) {
            return time -  request;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "request=" + request +
                    ", spend=" + spend +
                    '}';
        }
    }



    public static void main(String[] args) {
        int[][] i = {{0, 3}, {1, 9},{2, 6}};
        Solution s = new Solution();
        s.solution(i);

    }
}
