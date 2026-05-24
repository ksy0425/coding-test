/*
Programmers Level 1
저주의 숫자 3
반복문 문제
 */

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] number = new int[100];
        int count = 1;
        for (int i=0;i<number.length;i++) {
            while (count % 3 == 0 || String.valueOf(count).contains("3")) {
                count++;
            }
            number[i] = count++;
        }
        answer = number[n-1];

        return answer;
    }
}