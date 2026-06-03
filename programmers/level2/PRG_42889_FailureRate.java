/*
Programmers Level 2 2019 KAKAO BLIND RECRUITMENT
실패율
배열, 정렬 문제
 */

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] stayPlayer = new int[N];
        double[] failPercent = new double[N];
        int goalPlayer = 0;

        for (int i = 0; i < N; i++) {
            goalPlayer = 0;

            for (int k = 0; k < stages.length; k++) {
                if (stages[k] == i + 1)
                    stayPlayer[i]++;
                else if (stages[k] > i + 1)
                    goalPlayer++;
            }

            int reachPlayer = stayPlayer[i] + goalPlayer;

            if (reachPlayer == 0)
                failPercent[i] = 0;
            else
                failPercent[i] = (double) stayPlayer[i] / reachPlayer;
        }

        // 스테이지 번호 저장
        Integer[] stageNum = new Integer[N];
        for (int i = 0; i < N; i++) {
            stageNum[i] = i + 1;
        }

        // 실패율 기준 내림차순 정렬
        Arrays.sort(stageNum, (a, b) -> {
            if (failPercent[a - 1] == failPercent[b - 1]) {
                return a - b; // 실패율 같으면 번호 작은 스테이지 우선
            }
            return Double.compare(
                    failPercent[b - 1],
                    failPercent[a - 1]
            );
        });

        for (int i = 0; i < N; i++) {
            answer[i] = stageNum[i];
        }

        return answer;
    }
}