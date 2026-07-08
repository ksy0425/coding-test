/*
Programmers Level 2
크기가 작은 부분 문자열
연습 문제
 */

class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i=0; i<=t.length()-p.length();i++) {
            String sNum = t.substring(i, i+p.length());
            if (sNum.compareTo(p) <= 0)
                answer++;
        }

        return answer;
    }
}