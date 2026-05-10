/*
Programmers Level 1
다음에 올 숫자
등차수열, 등비수열 문제
 */

class Solution {
    public int solution(int[] common) {
        int answer = 0;

        if (common[1] - common[0] == common[2] - common[1]) {
            int commonDifference = common[1]-common[0];
            answer = common[common.length-1] + commonDifference;
        }
        else {
            int commonRatio = common[1] / common[0];
            answer = common[common.length-1] * commonRatio;
        }

        return answer;
    }
}