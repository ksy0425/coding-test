/*
Programmers Level 2
공원 산책
연습 문제
 */

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int x = 0, y = 0;
        for (int i=0;i<park.length;i++) {
            if (park[i].contains("S")) {
                answer[0] = i;
                char[] chars = park[i].toCharArray();
                for (int k=0;k<chars.length;k++) {
                    if (chars[k] == 'S')
                        answer[1] = k;
                }
            }
        }

        int dx = 0, dy = 0;
        int move = 0;
        for (int i=0;i<routes.length;i++) {
            String[] route = routes[i].split(" ");
            switch (route[0]) {
                case "N": dx = -1; dy = 0; move = Integer.parseInt(route[1]); break;
                case "E": dx = 0; dy = 1; move = Integer.parseInt(route[1]); break;
                case "W": dx = 0; dy = -1; move = Integer.parseInt(route[1]); break;
                case "S": dx = 1; dy = 0; move = Integer.parseInt(route[1]); break;
            }

            boolean canMove = true;

            // ===== 범위 검사 =====
            if (dy > 0) { // E
                if (answer[1] + move >= park[0].length()) {
                    canMove = false;
                }
            } else if (dy < 0) { // W
                if (answer[1] - move < 0) {
                    canMove = false;
                }
            } else if (dx > 0) { // S
                if (answer[0] + move >= park.length) {
                    canMove = false;
                }
            } else if (dx < 0) { // N
                if (answer[0] - move < 0) {
                    canMove = false;
                }
            }

            if (!canMove)
                continue;

            // 장애물 검사
            if (dy > 0) {
                // E방향 오른
                char[] chars = park[answer[0]].toCharArray();
                for (int k = 1; k <= move; k++) {
                    if (chars[answer[1] + k] == 'X') {
                        canMove = false;
                        break;
                    }
                }
                if (canMove) {
                    answer[1] += move;
                }
            }
            else if (dy < 0) {
                // W방향 왼
                char[] chars = park[answer[0]].toCharArray();
                for (int k = 1; k <= move; k++) {
                    if (chars[answer[1] - k] == 'X') {
                        canMove = false;
                        break;
                    }
                }
                if (canMove) {
                    answer[1] -= move;
                }
            }
            else if (dx > 0) {
                //S방향 아래
                for (int k = 1; k <= move; k++) {
                    if (park[answer[0] + k].charAt(answer[1]) == 'X') {
                        canMove = false;
                        break;
                    }
                }
                if (canMove) {
                    answer[0] += move;
                }
            }
            else if (dx < 0) {
                // N방향 위
                for (int k = 1; k <= move; k++) {
                    if (park[answer[0] - k].charAt(answer[1]) == 'X') {
                        canMove = false;
                        break;
                    }
                }
                if (canMove) {
                    answer[0] -= move;
                }
            }
        }

        return answer;
    }
}