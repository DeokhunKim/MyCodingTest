package code.c67257;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Long> originOperandList = new ArrayList<>();
    List<OPERATOR> originOperatorList = new ArrayList<>();

    public long solution(String expression) {
        long answer = 0;

        // 원본 데이터 분리하여 저장해놓기
        int j = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                originOperatorList.add(OPERATOR.plus);
                originOperandList.add(Long.parseLong(expression.substring(j, i)));
                j = i + 1;
            } else if (expression.charAt(i) == '-') {
                originOperatorList.add(OPERATOR.minus);
                originOperandList.add(Long.parseLong(expression.substring(j, i)));
                j = i + 1;
            } else if (expression.charAt(i) == '*') {
                originOperatorList.add(OPERATOR.multiply);
                originOperandList.add(Long.parseLong(expression.substring(j, i)));
                j = i + 1;
            }
        }
        originOperandList.add(Long.parseLong(expression.substring(j, expression.length())));

        for(OPERATOR operator1 : OPERATOR.values()){
            List<Long> operand_deep1 = new ArrayList<>();
            List<OPERATOR> operator_deep1= new ArrayList<>();
            nextDeep(originOperandList, originOperatorList, operand_deep1, operator_deep1, operator1 );
            if (operand_deep1.size() == 1) {
                long result = Math.abs(operand_deep1.get(0));
                if( answer < result)
                    answer = result;
                continue;
            }


            for(OPERATOR operator2 : OPERATOR.values()){
                if (operator1 == operator2) {
                    continue;
                }
                List<Long> operand_deep2 = new ArrayList<>();
                List<OPERATOR> operator_deep2= new ArrayList<>();
                nextDeep(operand_deep1, operator_deep1, operand_deep2, operator_deep2, operator2 );
                if (operand_deep2.size() == 1) {
                    long result = Math.abs(operand_deep2.get(0));
                    if( answer < result)
                        answer = result;
                    continue;
                }

                for(OPERATOR operator3 : OPERATOR.values()){
                    if (operator1 == operator3 || operator2 == operator3) {
                        continue;
                    }
                    List<Long> operand_deep3 = new ArrayList<>();
                    List<OPERATOR> operator_deep3= new ArrayList<>();
                    nextDeep(operand_deep2, operator_deep2, operand_deep3, operator_deep3, operator3 );
                    long result = Math.abs(operand_deep3.get(0));
                    if( answer < result)
                        answer = result;
                }

            }
        }


        return answer;
    }


    enum OPERATOR {
        plus, minus, multiply;

    }

    public void nextDeep(List<Long> operand_deep1, List<OPERATOR> operator_deep1,
                         List<Long> operand_deep2, List<OPERATOR> operator_deep2,
                         OPERATOR operator){
        long curNum = 0;
        boolean isStack = false;
        long targetNum = 0;
        for (int i = 0; i < operator_deep1.size(); i++) {
            if (!isStack) {
                targetNum = operand_deep1.get(i);
            } else {
                targetNum = curNum;
            }
            if (operator_deep1.get(i) == operator) {
                curNum = calculate(targetNum, operator, operand_deep1.get(i + 1));
                isStack = true;
                if (i != operator_deep1.size() - 1) {
                    continue;
                } else {
                    operand_deep2.add(curNum);
                    continue;
                }

            }
            operand_deep2.add(targetNum);
            operator_deep2.add(operator_deep1.get(i));
            curNum = 0;
            isStack = false;
            if (i == operator_deep1.size() - 1) {
                operand_deep2.add(operand_deep1.get(i+1));
            }
        }

    }


    public long calculate(long a, OPERATOR operator, long b) {
        if (operator == OPERATOR.plus) {
            return a + b ;
        }
        if (operator == OPERATOR.minus) {
            return a - b ;
        }
        if (operator == OPERATOR.multiply) {
            return a * b ;
        }
        return 0;
    }

    public static void main(String[] args) {
        long solution = new Solution().solution("2*2*2*2*2-2*2*2");
        System.out.println("solution = " + solution);
    }
}
