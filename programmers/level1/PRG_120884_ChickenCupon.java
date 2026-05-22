/*
Programmers Level 1
치킨 쿠폰
로직 구현 문제
 */

class Solution {
    public int solution(int chicken) {
        int answer = 0;

        int cupon = chicken; // 쿠폰 수
        int count =0;
        int remainCupon = cupon %10;
        while (cupon >= 10) {
            count += cupon/10; // 1
            remainCupon = cupon%10; // 0
            remainCupon += count; // 1
            cupon = remainCupon; // 1

            answer+= count; // 108+ 10 + 1 + 1
            count=0;
        }

        return answer;
    }
}