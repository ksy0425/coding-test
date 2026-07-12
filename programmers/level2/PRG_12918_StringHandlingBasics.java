/*
Programmers Level 2
문자열 다루기 기본
연습 문제
 */

class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        char[] cs = s.toCharArray();
        for (char c : cs) {
            if ((c>='A' && c<='Z') || (c>='a' && c<='z') || (s.length()!=4 && s.length()!=6)) {
                return false;
            }
        }

        return true;
    }
}