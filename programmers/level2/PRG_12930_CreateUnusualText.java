/*
Programmers Level 2
이상한 문자 만들기
연습 문제
 */

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ", -1);

        for (int i = 0; i < strArr.length; i++) {
            char[] c = strArr[i].toCharArray();
            for (int k = 0; k < c.length; k++) {
                if (k % 2 == 0) {
                    c[k] = Character.toUpperCase(c[k]);
                }
                else {
                    c[k] = Character.toLowerCase(c[k]);
                }
            }
            answer += String.valueOf(c);
            if (i < strArr.length - 1) {
                answer += " ";
            }

        }

        return answer;
    }
}