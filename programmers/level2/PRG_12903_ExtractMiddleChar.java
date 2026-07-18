/*
Programmers Level 2
가운데 글자 가져오기
연습 문제
 */

class Solution {
    public String solution(String s) {
        String answer = "";

        char[] chars = s.toCharArray();

        if (chars.length % 2 == 0) {
            answer = String.valueOf(chars[chars.length/2 - 1]) + String.valueOf(chars[chars.length/2]);
        }
        else {
            answer = String.valueOf(chars[chars.length/2]);
        }

        return answer;
    }
}