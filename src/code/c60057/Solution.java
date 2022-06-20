package code.c60057;

public class Solution {
    public int solution(String s) {
        // 최소 길이를 넘어가는 순간 continue
        // 다 짜르고 토큰 형식으로 수집?
        // 문자열을 통채로 비교하지 말고 첫글자로 넘어가기
        // 전체 길이의 절반 이상으로 자르는 것은 의미 없음
        // 3개로 안잘린다고 6개로 안짤리는 것은 아미

        int sLen = s.length();
        int answer = sLen;
        for (int c = 1; c <= sLen / 2; c++) {
            int subLen = 0;
            String debugStr = "";
            for (int l = 0; l < sLen; l++) {
                int countSame = 1;
                while (isSame(c, l, s)) {
                    countSame++;
                    l += c;
                }
                int addedNum = 0;
                if (countSame == 1) {
                    addedNum = 0;
                } else if (countSame == 1000) {
                    addedNum = 4;
                } else if (countSame / 100 != 0) {
                    addedNum = 3;
                }else if (countSame / 10 != 0) {
                    addedNum = 2;
                }else {
                    addedNum = 1;
                }
                subLen += (c + addedNum);
                l += c - 1;
                int endlen = l + 1;
                if (endlen > sLen - 1) {
                    endlen = sLen ;
                    subLen += sLen - l - 1;
                }

                //debug
                /*
                if (countSame != 0 && countSame != 1) {
                    debugStr += String.valueOf(countSame);
                }
                debugStr += s.substring(l-c + 1, endlen);
                */
            }
            if (answer > subLen) {
                answer = subLen;
            }
            //System.out.println("c:"+ c + "/" + debugStr + "/" + subLen);
        }


        return answer;
    }

    public boolean isSame(int c, int l, String s) {
        if (s.length() < l + c + c) {
            return false;
        }

        if (s.substring(l, l + c ).equals(s.substring(l + c , l + c + c ))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution("xababcdcdababcdcd");
        System.out.println("solution = " + solution);
    }
}
