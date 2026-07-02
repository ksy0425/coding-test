/*
Programmers Level 2
같은 숫자는 싫어
스택/큐 문제
 */

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        int index = 0;
        int[] storage = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1 && arr[i] == arr[i+1]) {
                if (i==arr.length-2) {
                    storage[index++] = arr[i];
                    break;
                }
                continue;
            }
            else {
                storage[index++] = arr[i];
            }
        }
        int[] answer = new int[index];
        for (int i=0;i<index; i++) {
            answer[i] = storage[i];
        }

        return answer;
    }
}