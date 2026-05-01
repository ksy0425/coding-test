/*
Programmers Level 1
정수를 나선형으로 배치하기
2차원 배열 시뮬레이션
*/

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0;
        int dir = 0;

        for (int i = 1; i <= n * n; i++) {
            answer[x][y] = i;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 벗어나거나 이미 채워진 경우
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || answer[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}