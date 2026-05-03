/*
Programmers Level 1
분수의 덧셈
정수론 (최대공약수, 약분) / 구현(분수 계산)
 */

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        answer[0] = numer1*denom2 + numer2*denom1;
        answer[1] = denom1 * denom2;

        int minNum = answer[0] < answer[1] ? answer[0] : answer[1];
        for (int i=2;i<=minNum;i++) {
            while (answer[0] % i == 0 && answer[1] % i == 0) {
                answer[0] /= i;
                answer[1] /= i;
            }
        }

        return answer;
    }
}