/*
Programmers Level 1
OX퀴즈
배열, 문자 나누기 문제
 */

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i=0;i<quiz.length;i++) {
            String[] block = quiz[i].split(" ");
            int[] num = new int[3];
            int numIndex = 0;
            for (int k=0;k<3;k++) {
                num[k] = Integer.parseInt(block[numIndex]);
                numIndex+=2;
            }

            if (block[1].equals("+")) {
                if (num[0] + num[1] == num[2])
                    answer[i] = "O";
                else
                    answer[i] = "X";
            }
            else {
                if (num[0] - num[1] == num[2])
                    answer[i] = "O";
                else
                    answer[i] = "X";
            }
        }

        return answer;
    }
}