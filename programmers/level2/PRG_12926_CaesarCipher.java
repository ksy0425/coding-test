/*
Programmers Level 2
시저 암호
문자 계산 문제
 */

class Solution {
    public String solution(String s, int n) {
        String answer = "";

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') { // 대문자
                c= (char) ('A' + (c - 'A' + n) % 26);
            }
            else if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + n) % 26);
            }
            answer = answer + String.valueOf(c);
        }

        return answer;
    }
}