/*
Programmers Level 1
등수 매기기
이차원 배열, 반복문 문제
 */

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];

        double[] averageScore = new double[score.length];
        for (int i=0;i<averageScore.length;i++) {
            averageScore[i] = ((double)score[i][0] + score[i][1])/2;
        }

        for (int i=0;i<averageScore.length; i++) {
            int rank = 1;
            for (int k=0;k<averageScore.length;k++) {
                if (averageScore[i] < averageScore[k]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }

        return answer;
    }
}