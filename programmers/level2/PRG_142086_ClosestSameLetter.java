/*
Programmers Level 2
가장 가까운 같은 글자
연습 문제
 */

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        char[] c = s.toCharArray();
        char[] visitor = new char[s.length()];

        for (int i=0;i<s.length(); i++) {
            visitor[i] = c[i];
            answer[i] = -1;
            for (int k=i-1;k>=0; k--) {
                if (c[i] == visitor[k]) {
                    answer[i] = i-k;
                    break;
                }
            }
        }

        return answer;
    }
}