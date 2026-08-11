/*
Programmers Level 2
노란불 신호등
2025 카카오 하반기 1차 문제
 */

class Solution {
    public int solution(int[][] signals) {
        int answer = -1;

        // 각 신호등의 주기
        int[] cycle = new int[signals.length];

        // 각 신호등의 노란불 시작 시간
        int[] yellowTime = new int[signals.length];

        for (int i = 0; i < signals.length; i++) {
            cycle[i] = signals[i][0] + signals[i][1] + signals[i][2];

            // 첫 번째 노란불 시작 시각
            yellowTime[i] = signals[i][0] + 1;
        }

        // 전체 주기 (LCM)
        int limit = 1;
        for (int i = 0; i < cycle.length; i++) {
            limit = lcm(limit, cycle[i]);
        }

        // 첫 번째 신호등 기준으로 탐색
        for (int time = yellowTime[0]; time <= limit; time += cycle[0]) {

            for (int offset = 0; offset < signals[0][1]; offset++) {

                int currentTime = time + offset;

                if (currentTime > limit)
                    break;

                boolean allYellow = true;

                for (int i = 0; i < signals.length; i++) {

                    int position = (currentTime - 1) % cycle[i];

                    if (position < signals[i][0] ||
                            position >= signals[i][0] + signals[i][1]) {

                        allYellow = false;
                        break;
                    }
                }

                if (allYellow)
                    return currentTime;
            }
        }

        return answer;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
