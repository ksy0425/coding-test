/*
Programmers Level 2
문자열 나누기
문자열 분해 문제
 */

class Solution {
    public int solution(String s) {
        int answer = 0;

        char[] cs = s.toCharArray();
        int firstCharIndex = 0;
        int sameCount = 0;
        int differentCount = 0;
        for (int i=0;i<cs.length;i++) {
            char firstChar = cs[firstCharIndex];
            if (firstChar == cs[i]) {
                sameCount++;
            }
            else {
                differentCount++;
            }

            if (sameCount == differentCount) {
                answer++;
                firstCharIndex = i+1;
            }
            else {
                if (i==cs.length-1)
                    answer++;
            }
        }
        if (answer == 0)
            answer+=1;

        return answer;
    }
}