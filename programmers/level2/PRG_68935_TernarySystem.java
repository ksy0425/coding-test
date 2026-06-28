/*
Programmers Level 2
3진법 뒤집기
월간 코드 챌린지 시즌1
 */

class Solution {
    public int solution(int n) {
        String ternary = "";

        while (n > 0) {
            ternary += n % 3;
            n /= 3;
        }

        return Integer.parseInt(ternary, 3);
    }
}