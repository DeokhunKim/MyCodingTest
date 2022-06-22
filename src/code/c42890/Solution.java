package code.c42890;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int solution(String[][] relation) {
        // 1개짝 검사, 2개짝 검사, 3개짝 검사 ....
        // 이미 후보키가 된 짝은 다른짝 검사에 포함 안되도록 처리해야함
        // > 하지만 그 짝의 부분짝은 검사해야함
        // 비트로?해서 검출된 비트랑 & 해서 완전 겹치면 패스

        // 1 2 4 8 3 5 9 6 12 7 11 14
        int answer = 0;
        int numRecord = relation.length;
        int numColumn = relation[0].length;

        List<Integer> findKeyBit = new ArrayList<>();
        List<Integer>[] targetBitList = new ArrayList[numColumn+1];
        for (int i = 0; i < targetBitList.length; i++) {
            targetBitList[i] = new ArrayList<>();
        }

        for (int i = 1; i < Math.pow(2, numColumn); i++) {
            int count = 0;
            for (int j = 0; j <= numColumn; j++) {
                if (((1 << j) & i) != 0) {
                    count++;
                }
            }
            targetBitList[count].add(i);
        }

        for (List<Integer> bitList : targetBitList) {
            for (Integer bit : bitList) {
                boolean isDuplicate = false;
                for (Integer findKey : findKeyBit) {
                    if ((findKey & bit) == findKey) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (isDuplicate) {
                    continue;
                }
                Set<String> checkDuplicate = new HashSet<>();
                boolean isNotCandidate = false;
                for (int record = 0; record < numRecord; record++) {
                    String key = makeKeyStr(relation, record, bit, numColumn);
                    if (!checkDuplicate.add(key)) {
                        isNotCandidate = true;
                        break;
                    }
                }
                if (isNotCandidate) {
                    continue;
                }

                // 후보키 자격이 있다.
                findKeyBit.add(bit);
                answer++;
                System.out.println("bit = " + bit);




            }
        }





        return answer;
    }

    public String makeKeyStr(String[][] relation, int record, Integer bit,  int numColumn) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numColumn; i++) {
            if ((1<<i & bit) != 0) {
                stringBuilder.append(relation[record][i] + "/");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[][] input = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int solution = new Solution().solution(input);
        System.out.println("solution = " + solution);
    }
}
