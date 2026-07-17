/*
Programmers Level 2
부족한 금액 계산하기
위클리 챌린지 문제
 */

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long total = money;
        for (int i=1;i<=count;i++) {
            total -= price * i;
        }
        if (total < 0)
            answer = Math.abs(total);
        else
            answer = 0;

        return answer;
    }
}