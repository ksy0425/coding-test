/*
Programmers Level 2
약수의 개수와 덧셈
월간 코드 챌린지 시즌2 문제
 */

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = 0;
            for (int k = 1; k <= (i / 2); k++) {
                if (i % k == 0) {
                    count++;
                }
            }

            if (count % 2 == 0)
                answer -= i;
            else
                answer += i;
        }

        return answer;
    }
}