/*
Programmers Level 2
콜라츠 추측
연습 문제
 */

class Solution {
    public int solution(int num) {
        int answer = 0;

        long n = num;
        int i=0;
        for (; i< 500; i++) {
            if (n ==1)
                break;
            else {
                if (n % 2 == 0 )
                    n /= 2;
                else
                    n = n*3 +1;
            }
        }
        if (i>=500)
            answer = -1;
        else
            answer = i;
        return answer;
    }
}