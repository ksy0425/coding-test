/*
Programmers Level 2
최대공약수와 최소공배수
연습 문제
 */

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int smallNum = 0;
        int largeNum = 0;
        if (n < m) {
            smallNum = n;
            largeNum = m;
        }
        else {
            smallNum = m;
            largeNum = n;
        }

        for (int i = 1; i <= smallNum; i++) {
            if ( n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }

        answer[1] = (n*m) / answer[0];

        return answer;
    }
}