/*
Programmers Level 2
k번째수
배열 인덱스, 정렬 문제
 */

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i=0;i<commands.length;i++) {
            int[] separateArr = new int[commands[i][1] - commands[i][0] + 1];
            for (int k=0;k<separateArr.length; k++) {
                separateArr[k] = array[(commands[i][0]-1)+k];
            }
            Arrays.sort(separateArr);
            answer[i] = separateArr[commands[i][2] - 1];
        }

        return answer;
    }
}