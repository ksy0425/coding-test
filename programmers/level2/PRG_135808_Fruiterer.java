/*
Programmers Level 2
과일 장수
정렬 문제
 */

import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        int appleTotal = score.length;
        Arrays.sort(score);

        for (int i = appleTotal-m; i>=0; i -= m) {
            answer += score[i]*m*1;
        }

        return answer;
    }
}