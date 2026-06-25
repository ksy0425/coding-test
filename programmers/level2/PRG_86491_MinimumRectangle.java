/*
Programmers Level 2
가장 가까운 같은 글자
연습 문제
 */

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int max = 0;
        int[] smallSize = new int[sizes.length];
        for (int i=0; i<sizes.length; i++) {
            for (int k=0;k<sizes[i].length;k++) {
                if (max < sizes[i][k]) {
                    max = sizes[i][k];
                }
            }
        }

        answer = max;

        for (int i=0;i<sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                smallSize[i] = sizes[i][0];
            }
            else {
                smallSize[i] = sizes[i][1];
            }
        }

        int sSizeBigest = smallSize[0];
        for (int i=0;i<smallSize.length; i++) {
            if (sSizeBigest < smallSize[i])
                sSizeBigest = smallSize[i];
        }

        answer *= sSizeBigest;

        return answer;
    }
}