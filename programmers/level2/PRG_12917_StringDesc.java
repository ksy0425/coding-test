/*
Programmers Level 2
문자열 내림차순으로 배치하기
연습 문제
 */

import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(new String(chars));
        answer = sb.reverse().toString();

        return answer;
    }
}