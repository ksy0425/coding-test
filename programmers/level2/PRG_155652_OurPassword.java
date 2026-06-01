/*
Programmers Level 2
둘만의 암호
반복문, 문자열 문자 비교 문제
 */

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        char[] cS = s.toCharArray();

        for (int i = 0; i < cS.length; i++) {

            int count = 0;

            while (count < index) {

                cS[i]++;

                if (cS[i] > 'z')
                    cS[i] = 'a';

                if (skip.indexOf(cS[i]) == -1)
                    count++;
            }
        }

        answer = new String(cS);
        return answer;
    }
}