/*
Programmers Level 2
푸드 파이터 대회
연습 문제
 */

class Solution {
    public String solution(int[] food) {
        String answer = "";

        int eatCount = 0;
        for (int i=1;i<food.length; i++) {
            eatCount = food[i] / 2;
            for (int k=0;k<eatCount;k++) {
                answer += i;
            }
        }
        answer += 0;
        for (int i = food.length-1; i>0; i--) {
            eatCount = food[i] / 2;
            for (int k=0;k<eatCount;k++) {
                answer += i;
            }
        }
        return answer;
    }
}