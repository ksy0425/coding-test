/*
Programmers Level 1
겹치는 선분의 길이
2차원 배열 시뮬레이션
 */

class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[201];

        for (int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;

            for (int i = start; i < end; i++) {
                arr[i]++;
            }
        }

        int answer = 0;
        for (int i = 0; i < 201; i++) {
            if (arr[i] >= 2) {
                answer++;
            }
        }

        return answer;
    }
}