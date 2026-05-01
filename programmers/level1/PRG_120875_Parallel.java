/*
Programmers Level 1
평행
2차원 배열 시뮬레이션
 */

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;

        int x1 = dots[0][0];
        int y1 = dots[0][1];

        int x2 = dots[1][0];
        int y2 = dots[1][1];

        int x3 = dots[2][0];
        int y3 = dots[2][1];

        int x4 = dots[3][0];
        int y4 = dots[3][1];

        if ((x3-x4)*(y1-y2) == (x1-x2)*(y3-y4)) {
            answer = 1;
        } else if ((x2-x4)*(y1-y3) == (x1-x3)*(y2-y4)) {
            answer = 1;
        } else if ((x2-x3)*(y1-y4) == (x1-x4)*(y2-y3)) {
            answer = 1;
        }

        return answer;
    }
}