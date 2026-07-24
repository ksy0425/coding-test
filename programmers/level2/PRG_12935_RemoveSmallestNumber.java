/*
Programmers Level 2
제일 작은 수 제거하기
연습 문제
 */

class Solution {
    public int[] solution(int[] arr) {

        if (arr.length == 1)
            return new int[]{-1};

        int minIndex = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] < arr[minIndex])
                minIndex = i;
        }

        int[] answer = new int[arr.length-1];
        int idx = 0;
        for (int i=0;i<arr.length; i++) {
            if (i==minIndex)
                continue;
            answer[idx++] = arr[i];
        }

        return answer;
    }
}