/*
Programmers Level 2
체육복
정렬 후 반복문 문제
 */

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i=0; i<lost.length; i++) {
            for (int k=0; k<reserve.length; k++) {
                if (lost[i]==reserve[k]) {
                    lost[i] = -1;
                    reserve[k] = -1;
                    break;
                }
            }
        }

        for (int i=0; i<lost.length; i++) {
            if (lost[i] == -1) continue;
            for (int k=0; k<reserve.length; k++) {
                if (reserve[k] == -1) continue;
                if (reserve[k] == lost[i]-1 || reserve[k] == lost[i]+1) {
                    lost[i] = -1;
                    reserve[k] = -1;
                    break;
                }
            }
        }

        int realLostCount = 0;
        for (int i: lost) {
            if ( i != -1)
                realLostCount++;
        }
        answer = n-realLostCount;

        return answer;
    }
}