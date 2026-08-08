/*
Programmers Level 2
택배 상자 꺼내기
2025 프로그래머스 코드챌린지 2차 예선 문제
 */

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;

        int height = getHeight(n, w);
        int[][] storage = new int[height][w];

        int boxNum = 0;
        boolean leftToRight = true;
        for (int i = height - 1; i >= 0; i--) {

            if (leftToRight) {
                for (int k = 0; k < w && boxNum < n; k++)
                    storage[i][k] = ++boxNum;
            }

            else {
                for (int k = w - 1; k >= 0 && boxNum < n; k--)
                    storage[i][k] = ++boxNum;
            }

            leftToRight = !leftToRight;
        }

        for (int i = height - 1; i >= 0; i--) {
            for (int k = 0; k < w; k++) {
                if (storage[i][k] == num) {
                    while (i > 0) {
                        if (storage[--i][k] != 0)
                            answer++;
                    }
                }
            }
        }

        return answer;
    }

    public int getHeight(int n, int w) {
        if (n == w)
            return 0;
        else if (n % w == 0)
            return n / w;
        else
            return n / w + 1;
    }

}