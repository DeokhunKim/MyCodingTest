package code.c81303;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    Stack<Integer> removeLog = new Stack<>();
    int sel = 0;
    int n = 0;
    boolean[] isLive = new boolean[1000000];
    public String solution(int n, int k, String[] cmd) {
        //init
        String answer = "";
        sel = k;
        Arrays.fill(isLive, true);
        this.n = n;

        for (String s : cmd) {
            char command = s.charAt(0);
            if (command == 'U') {
                s = s.replace("U ", "");
                int c = Integer.parseInt(s);
                moveUp(c);
            }else if (command == 'D') {
                s = s.replace("D ", "");
                int c = Integer.parseInt(s);
                moveDown(c);
            }
            else if (command == 'C') {
                remove();
            }
            else if (command == 'Z') {
                redo();
            }
        }
        char resultChar[] = new char[1000000];
        for (int i = 0; i < n; i++) {
            if (isLive[i]) {
                resultChar[i] = 'O';
            } else {
                resultChar[i] = 'X';
            }
        }

        answer = String.copyValueOf(resultChar, 0, n);

        return answer;
    }

    boolean moveUp(int c) {
        for (int i = 0; i < c; i++) {
            while (true) {
                sel -= 1;
                if (isLive[sel]) {
                    break;
                }
            }
        }
        return true;
    }
    boolean moveDown(int c) {
        int origin = sel;
        for (int i = 0; i < c; i++) {
            while (true) {
                sel += 1;
                if (isLive[sel]) {
                    break;
                }
            }
        }
        return true;
    }
    boolean moveDown() {
        int origin = sel;
        while (true) {
            sel += 1;
            if (sel == n) {
                sel = origin;
                return false;
            }
            if (isLive[sel]) {
                break;
            }
        }

        return true;
    }

    void remove() {
        int removeIndex = sel;
        if (!moveDown()) {
            moveUp(1);
        }
        isLive[removeIndex] = false;
        removeLog.push(removeIndex);
    }

    void redo() {
        int index = removeLog.pop();
        isLive[index] = true;
    }


    public static void main(String[] args) {
        String[] i = {"C", "D 18", "C"};
        Solution solution = new Solution();
        solution.solution(20, 0, i);
    }
}
