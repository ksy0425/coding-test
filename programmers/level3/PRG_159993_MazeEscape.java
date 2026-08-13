/*
Programmers Level 3
미로 탈출
연습 문제
 */

import java.util.*;

class Solution {

    public int solution(String[] maps) {

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        String[][] map = new String[maps.length][maps[0].length()];

        // String[] → String[][]
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
        }

        // S, L, E 위치 찾기
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[i].length; k++) {

                if (map[i][k].equals("S")) {
                    start[0] = i;
                    start[1] = k;
                }
                else if (map[i][k].equals("L")) {
                    lever[0] = i;
                    lever[1] = k;
                }
                else if (map[i][k].equals("E")) {
                    end[0] = i;
                    end[1] = k;
                }
            }
        }

        // S → L
        int startToLever = bfs(map, start, lever);

        // 레버에 도달할 수 없다면 실패
        if (startToLever == -1) {
            return -1;
        }

        // L → E
        int leverToEnd = bfs(map, lever, end);

        // 출구에 도달할 수 없다면 실패
        if (leverToEnd == -1) {
            return -1;
        }

        return startToLever + leverToEnd;
    }


    public int bfs(String[][] map, int[] start, int[] target) {

        int n = map.length;
        int m = map[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        // {행, 열, 이동거리}
        queue.offer(new int[]{start[0], start[1], 0});

        visited[start[0]][start[1]] = true;

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            int distance = cur[2];

            // 목표 도착
            if (x == target[0] && y == target[1]) {
                return distance;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 범위를 벗어난 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // 벽인 경우
                if (map[nx][ny].equals("X")) {
                    continue;
                }

                // 이미 방문한 경우
                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;

                queue.offer(new int[]{nx, ny, distance + 1});
            }
        }

        // 도달할 수 없는 경우
        return -1;
    }
}