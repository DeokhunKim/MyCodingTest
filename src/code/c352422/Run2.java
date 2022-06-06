package code.c352422;

import java.util.Vector;

public class Run2 {

    public static void main(String[] args) {
        String dartResult = "1D#2S*3S";

        String paseStr = "";
        Vector<Integer> result = new Vector<>();
        int location = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c =  dartResult.charAt(i);

            if (Character.isDigit(c)) {
                paseStr += c;
                continue;
            }

            if (c == 'S') {
                result.add(Integer.parseInt(paseStr));
                location++;
            } else if (c == 'D') {
                result.add(Integer.parseInt(paseStr)*Integer.parseInt(paseStr));
                location++;
            } else if (c == 'T') {
                result.add(Integer.parseInt(paseStr)*Integer.parseInt(paseStr)*Integer.parseInt(paseStr));
                location++;
            }

            if (c == '*') {
                result.set(location - 1, result.elementAt(location - 1) * 2);
                if (location != 1) {
                    result.set(location - 2, result.elementAt(location - 2) * 2);
                }
            }

            if (c == '#') {
                result.set(location - 1, result.elementAt(location - 1) * -1);
            }

            paseStr = "";

        }

        int answer = 0;
        for (Integer integer : result) {
            answer += integer;
        }



    }





}
