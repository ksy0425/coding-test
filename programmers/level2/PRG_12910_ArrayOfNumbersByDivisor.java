/*
Programmers Level 2
나누어 떨어지는 숫자 배열
연습 문제
 */

import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] flag = new int[arr.length];
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                flag[i] = 1;
                count++;
            }
            else {
                flag[i] = 0;
            }
        }
        if (count == 0)
            return new int[]{-1};
        int[] answer = new int[count];
        if (count > 0) {
            int index = -1;
            for (int i = 0; i < flag.length; i++) {
                if (flag[i] == 1)
                    answer[++index] = arr[i];
            }
        }

        return answer;
    }
}