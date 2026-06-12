/*
Programmers Level 2
기사단원의 무기
*/

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i=1;i<=number;i++) {
            int numDivisorCount = 0;
            numDivisorCount = getDivisor(i);

            if (numDivisorCount <= limit) {
                answer += numDivisorCount;
            }
            else {
                answer += power;
            }
        }

        return answer;
    }

    public int getDivisor(int num) {
        int result = 0;
        for (int i=1;i<=num; i++) {
            if (num%i==0)
                result++;
        }
        return result;
    }
}