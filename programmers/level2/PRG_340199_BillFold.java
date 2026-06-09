/*
Programmers Level 2 [PCCE 기출문제] 9번
지폐 접기
삼항 연산자, 의사코드 문제
 */

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while ((bill[0] < bill[1] ? bill[0] : bill[1]) > (wallet[0] < wallet[1] ? wallet[0] : wallet[1]) || (bill[0] < bill[1] ? bill[1] : bill[0]) > (wallet[0] < wallet[1] ? wallet[1] : wallet[0])) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            }
            else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }
}