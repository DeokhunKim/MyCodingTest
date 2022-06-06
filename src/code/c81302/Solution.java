package code.c81302;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        for (String[] place : places) {
            if (checkRoom(place)) {
                answerList.add(1);
            } else {
                answerList.add(0);
            }
        }

        System.out.println("answerList.toString() = " + answerList.toString());
        answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }

    private boolean checkRoom(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    int location = i * 5 + j;
                    if (!checkLocation(place, 0, j, i, location)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean checkLocation(String[] place, int deep, int x, int y, int fromLocation) {
        int location = y * 5 + x;
        if (x == 0) {
            if (fromLocation != (location + 1) && place[y].charAt(x + 1) == 'P') {
                return false;
            } else if (deep == 0 && place[y].charAt(x + 1) == 'O' && !checkLocation(place, 1, x + 1, y, fromLocation)) {
                return false;
            }
        } else if( x == 4) {
            if (fromLocation != (location - 1) && place[y].charAt(x - 1) == 'P') {
                return false;
            } else if (deep == 0 && place[y].charAt(x - 1) == 'O' && !checkLocation(place, 1, x - 1, y, fromLocation)) {
                return false;
            }
        } else{
            if (fromLocation != (location + 1) && place[y].charAt(x + 1) == 'P') {
                return false;
            } else if (deep == 0 && place[y].charAt(x + 1) == 'O' && !checkLocation(place, 1, x + 1, y, fromLocation)) {
                return false;
            }
            if (fromLocation != (location - 1) && place[y].charAt(x - 1) == 'P') {
                return false;
            } else if (deep == 0 && place[y].charAt(x - 1) == 'O' && !checkLocation(place, 1, x - 1, y, fromLocation)) {
                return false;
            }
        }


        if (y == 0) {
            if (fromLocation != (location + 5) && place[y+1].charAt(x) == 'P') {
                return false;
            } else if (deep == 0 && place[y+1].charAt(x) == 'O' && !checkLocation(place, 1, x, y + 1, fromLocation)) {
                return false;
            }
        } else if (y == 4) {
            if (fromLocation != (location - 5) && place[y-1].charAt(x) == 'P') {
                return false;
            } else if (deep == 0 && place[y-1].charAt(x) == 'O' && !checkLocation(place, 1, x, y - 1, fromLocation)) {
                return false;
            }
        } else {
            if (fromLocation != (location + 5) && place[y+1].charAt(x) == 'P') {
                return false;
            } else if (deep == 0 && place[y+1].charAt(x) == 'O' && !checkLocation(place, 1, x, y + 1, fromLocation)) {
                return false;
            }
            if (fromLocation != (location - 5) && place[y-1].charAt(x) == 'P') {
                return false;
            } else if (deep == 0 && place[y-1].charAt(x) == 'O' && !checkLocation(place, 1, x, y - 1, fromLocation)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {


        String[][] i = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Solution solution = new Solution();
        solution.solution(i);


    }

}
