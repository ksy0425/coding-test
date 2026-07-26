/*
Programmers Level 2
핸드폰 번호 가리기
연습 문제
 */

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        char[] chars = phone_number.toCharArray();
        for (int i = 0; i < phone_number.length(); i++) {
            if (i >= chars.length - 4)
                answer += String.valueOf(chars[i]);
            else
                answer += "*";
        }

        return answer;
    }
}