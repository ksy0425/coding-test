/*
Programmers Level 2 [2018 KAKAO BLIND RECRUITMENT]
[1차] 다트 게임
배열 인덱스, 분기 처리 문제
 */

class Solution {
    public int solution(String dartResult) {

        int[] score = new int[3];
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {

            char ch = dartResult.charAt(i);

            // 숫자 처리
            if (Character.isDigit(ch)) {

                idx++;

                // 10 처리
                if (ch == '1' && i + 1 < dartResult.length()
                        && dartResult.charAt(i + 1) == '0') {

                    score[idx] = 10;
                    i++;
                } else {
                    score[idx] = ch - '0';
                }
            }

            // S D T 처리
            else if (ch == 'S') {
                score[idx] = (int)Math.pow(score[idx], 1);

            } else if (ch == 'D') {
                score[idx] = (int)Math.pow(score[idx], 2);

            } else if (ch == 'T') {
                score[idx] = (int)Math.pow(score[idx], 3);
            }

            // 옵션 처리
            else if (ch == '*') {

                score[idx] *= 2;

                if (idx > 0) {
                    score[idx - 1] *= 2;
                }

            } else if (ch == '#') {

                score[idx] *= -1;
            }
        }

        return score[0] + score[1] + score[2];
    }
}