/*
Programmers Level 1
문자열 밀기
문자열, 문자 조작 문제
 */

class Solution {
    public int solution(String A, String B) {
        int answer = 0;

        if (A.equals(B))
            return answer;

        char[] charArrayA = A.toCharArray();
        int count = 0;
        while(A.length() != count) {
            count++;
            char temp = charArrayA[charArrayA.length-1];
            for (int i=charArrayA.length-1;i>0;i--) {
                charArrayA[i] = charArrayA[i-1];
            }
            charArrayA[0] = temp;
            answer++; // 밀기 끝 횟수 증가
            //이제 비교
            A = new String(charArrayA);
            if (A.equals(B))
                return answer;
        }

        // 될 수 없음
        return -1;
    }
}