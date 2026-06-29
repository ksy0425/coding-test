/*
Programmers Level 2
예산
Summer/Winter Coding(~2018) 문제
 */

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (int i=0; i<d.length; i++) {
            if (budget >= d[i]) {
                budget -= d[i];
                answer++;
            }
        }

        return answer;
    }
}