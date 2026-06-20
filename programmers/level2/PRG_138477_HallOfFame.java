/*
Programmers Level 2
명예의 전당(1)
우선순위 큐 문제
 */

import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int days = score.length;
        int[] answer = new int[days];
        int[] rank = new int[k];

        for (int i=0;i<days;i++) {
            if (i<k) {
                rank[i] = score[i];
                int minScore = rank[0];
                for (int j=1; j<=i;j++) {
                    if (rank[j]<minScore)
                        minScore=rank[j];
                }
                answer[i] = minScore;
            }

            else {
                Arrays.sort(rank);
                if (rank[0] < score[i]) {
                    rank[0] = score[i];
                    Arrays.sort(rank);
                }
                answer[i] = rank[0];
            }

        }

        return answer;
    }
}