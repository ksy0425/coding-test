/*
Programmers Level 2
성격 유형 검사하기
2022 KAKAO TECH INTERNSHIP 문제
 */

/*
1번 지표	라이언형(R), 튜브형(T)
2번 지표	콘형(C), 프로도형(F)
3번 지표	제이지형(J), 무지형(M)
4번 지표	어피치형(A), 네오형(N)
*/

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int[] scoreBoard = new int[8];
        for (int i=0; i<survey.length; i++) {
            int score = 0;
            if (survey[i].contains("R")) {
                score = checkChoice(choices[i]);
                String[] type = survey[i].split("");
                if (type[0].equals("R")) {
                    if (choices[i] < 4)
                        scoreBoard[0] += score;
                    else if (choices[i] > 4)
                        scoreBoard[1] += score;
                }
                else {
                    if (choices[i] < 4)
                        scoreBoard[1] += score;
                    else if (choices[i] > 4)
                        scoreBoard[0] += score;
                }
            }

            else if (survey[i].contains("C")) {
                score = checkChoice(choices[i]);
                String[] type = survey[i].split("");
                if (type[0].equals("C")) {
                    if (choices[i] < 4)
                        scoreBoard[2] += score;
                    else if (choices[i] > 4)
                        scoreBoard[3] += score;
                }
                else {
                    if (choices[i] < 4)
                        scoreBoard[3] += score;
                    else if (choices[i] > 4)
                        scoreBoard[2] += score;
                }
            }

            else if (survey[i].contains("J")) {
                score = checkChoice(choices[i]);
                String[] type = survey[i].split("");
                if (type[0].equals("J")) {
                    if (choices[i] < 4)
                        scoreBoard[4] += score;
                    else if (choices[i] > 4)
                        scoreBoard[5] += score;
                }
                else {
                    if (choices[i] < 4)
                        scoreBoard[5] += score;
                    else if (choices[i] > 4)
                        scoreBoard[4] += score;
                }
            }

            else if (survey[i].contains("A")) {
                score = checkChoice(choices[i]);
                String[] type = survey[i].split("");
                if (type[0].equals("A")) {
                    if (choices[i] < 4)
                        scoreBoard[6] += score;
                    else if (choices[i] > 4)
                        scoreBoard[7] += score;
                }
                else {
                    if (choices[i] < 4)
                        scoreBoard[7] += score;
                    else if (choices[i] > 4)
                        scoreBoard[6] += score;
                }
            }

        }

        // 이제 지표에 대한 점수가 다 나왔을 거임.
        for (int i =0 ;i<scoreBoard.length; i+=2) {
            if (scoreBoard[i] >= scoreBoard[i+1]) {
                switch (i) {
                    case 0: answer += "R"; break;
                    case 2: answer += "C"; break;
                    case 4: answer += "J"; break;
                    case 6: answer += "A"; break;
                }
            }
            else if (scoreBoard[i] < scoreBoard[i+1]) {
                switch (i+1) {
                    case 1: answer += "T"; break;
                    case 3: answer += "F"; break;
                    case 5: answer += "M"; break;
                    case 7: answer += "N"; break;
                }
            }
        }

        return answer;
    }

    public int checkChoice(int choice) {
        switch (choice) {
            case 1, 7: return 3;
            case 2, 6: return 2;
            case 3, 5: return 1;
            case 4: return 0;
            default: return -1;
        }
    }
}