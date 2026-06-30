/*
Programmers Level 2
삼총사
연습 문제
 */

import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;

        Arrays.sort(number); // 3중 반복 할거면 정렬 필요 없음, 하지만 투 포인터 풀이할 시 필요

        for (int i=0;i<number.length; i++) {
            for (int k=i+1;k<number.length; k++) {
                for (int j=k+1;j<number.length;j++) {
                    if (number[i] + number[k] + number[j] == 0)
                        answer++;
                }
            }
        }

        return answer;
    }
}