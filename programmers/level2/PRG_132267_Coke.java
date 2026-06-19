/*
Programmers Level 2
콜라 문제
계산 문제
 */

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        int emptyBottle = n;

        while (emptyBottle >= a) {
            answer += (emptyBottle/a)*b;
            emptyBottle = (emptyBottle%a) + (emptyBottle/a)*b;
        }

        return answer;
    }
}