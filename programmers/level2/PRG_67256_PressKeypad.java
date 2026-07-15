/*
Programmers Level 2
키패드 누르기
2020 카카오 인턴십 문제
 */

class Solution {
    public String solution(int[] numbers, String hand) {
        char[][] keyPad = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}};
        String answer = "";

        char leftLocation = '*';
        char rightLocation = '#';

        for (int i=0;i<numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                leftLocation = (char)(numbers[i] + '0');
            }
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                rightLocation = (char)(numbers[i] + '0');
            }
            else {
                int leftDistance = 0;
                int rightDistance = 0;

                int[] leftIndex = new int[2];
                int[] rightIndex = new int[2];
                for (int k=0;k<keyPad.length; k++) {
                    for (int j=0;j<keyPad[k].length;j++) {
                        if (keyPad[k][j] == leftLocation) {
                            leftIndex[0] = k;
                            leftIndex[1] = j;
                        }
                        else if (keyPad[k][j] == rightLocation) {
                            rightIndex[0] = k;
                            rightIndex[1] = j;
                        }
                    }
                }

                for (int k=0;k<keyPad.length; k++) {
                    if (keyPad[k][1] == (char)(numbers[i] + '0')) {
                        if (Math.abs(k-leftIndex[0]) + Math.abs(1-leftIndex[1]) < Math.abs(k-rightIndex[0]) + Math.abs(1-rightIndex[1])) {
                            answer += "L";
                            leftLocation = (char)(numbers[i] + '0');
                        }
                        else if (Math.abs(k-leftIndex[0]) + Math.abs(1-leftIndex[1]) > Math.abs(k-rightIndex[0]) + Math.abs(1-rightIndex[1])) {
                            answer += "R";
                            rightLocation = (char)(numbers[i] + '0');
                        }
                        else {
                            if (hand.equals("left")) {
                                answer += "L";
                                leftLocation = (char)(numbers[i] + '0');
                            }
                            else {
                                answer += "R";
                                rightLocation = (char)(numbers[i] + '0');
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}