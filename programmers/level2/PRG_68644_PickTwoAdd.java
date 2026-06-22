/*
Programmers Level 2
두 개 뽑아서 더하기
월간 코드 챌린지 시즌1 문제
 */

class Solution {
    public int[] solution(int[] numbers) {

        int[] result = new int[201];

        for (int i=0;i<numbers.length-1; i++) {
            for (int k=i+1;k<numbers.length; k++) {
                result[numbers[i] + numbers[k]] = 1;
            }
        }

        int resultCount = 0;
        for (int i=0;i<result.length;i++) {
            if (result[i] == 1)
                resultCount++;
        }
        int[] answer = new int[resultCount];
        int answerIndex = 0;
        for (int i=0;i<result.length;i++) {
            if (result[i] == 1)
                answer[answerIndex++] = i;
        }

        return answer;
    }
}