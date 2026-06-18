/*
Programmers Level 2
숫자 문자열과 영단어
타입 변경 문제
 */

class Solution {
    public int solution(String s) {
        int answer = 0;

        final String[] word = {"zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"};

        for (int i=0;i<word.length; i++) {
            s = s.replace(word[i], String.valueOf(i));
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}