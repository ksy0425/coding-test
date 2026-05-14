/*
Programmers Level 1
다항식 더하기
동류항 계산 문제
 */

class Solution {
    public String solution(String polynomial) {
        String answer = "";

        String formula[] = polynomial.split(" ");
        int numTerm = 0;
        int xTerm = 0;
        for (int i=0;i<formula.length;i++) {
            if (formula[i].equals("+"))
                continue;

            if (formula[i].contains("x")) {
                formula[i] = formula[i].replace("x", "");
                if (formula[i].equals(""))
                    xTerm+=1;
                else
                    xTerm += Integer.parseInt(formula[i]);
            }
            else {
                numTerm += Integer.parseInt(formula[i]);
            }

        }

        if (xTerm != 0 && numTerm != 0) {
            return (xTerm == 1 ? "x" : xTerm + "x") + " + " + numTerm;
        } else if (xTerm != 0) {
            return (xTerm == 1 ? "x" : xTerm + "x");
        } else {
            return String.valueOf(numTerm);
        }
    }
}