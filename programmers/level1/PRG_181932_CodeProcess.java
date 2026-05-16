/*
Programmers Level 1
코드 처리하기
인덱스, 조건문 문제
 */

class Solution {
    public String solution(String code) {
        String answer = "";

        int mode = 0;
        char[] charArray = code.toCharArray();
        for (int idx=0;idx<code.length();idx++) {
            if (mode == 0) {
                if (charArray[idx] != '1' && idx % 2 == 0)
                    answer += charArray[idx];
                else if (charArray[idx] == '1')
                    mode = 1;
            }

            else {
                if (charArray[idx] != '1' && idx % 2 != 0 )
                    answer += charArray[idx];
                else if (charArray[idx] == '1')
                    mode = 0;
            }
        }

        return answer != "" ? answer:"EMPTY";
    }
}