/*
Programmers Level 2
모의고사
완전탐색 문제
 */

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] omr1 = {1, 2, 3, 4, 5};
        int[] omr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] omr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] collect = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == omr1[i % omr1.length]) collect[0]++;
            if (answers[i] == omr2[i % omr2.length]) collect[1]++;
            if (answers[i] == omr3[i % omr3.length]) collect[2]++;
        }

        int max = 0;
        for (int c : collect) if (c > max) max = c;

        int cnt = 0;
        for (int c : collect) if (c == max) cnt++;

        int[] answer = new int[cnt];
        int idx = 0;
        for (int i = 0; i < collect.length; i++) {
            if (collect[i] == max) answer[idx++] = i + 1;
        }
        return answer;
    }
}