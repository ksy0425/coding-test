/*
Programmers Level 1
연속된 수의 합
등차수열 문제
 */

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = (total - num*(num-1)/2) / num;

        for (int i=0; i<num; i++) {
            answer[i] = start + i;
        }
        return answer;
    }
}