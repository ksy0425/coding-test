/*
Programmers Level 3
마법의 엘리베이터
연습 문제
 */

class Solution {
    public int solution(int storey) {
        int answer = 0;


        while (storey > 0) {
            if (storey % 10 < 5) {
                for (int i=0;i<storey % 10; i++) {
                    answer++;
                }
                storey = storey / 10;
            }

            else if (storey % 10 == 5) {
                if ((storey / 10) % 10 < 5) { // 내림
                    for (int i=0;i<storey % 10; i++) {
                        answer++;
                    }
                    storey = storey / 10;
                }
                else { // 올림
                    for (int i=storey % 10;i<10; i++) {
                        answer++;
                    }
                    storey = storey / 10 + 1;
                }
            }

            else {
                for (int i=storey % 10;i<10; i++) {
                    answer++;
                }
                storey = storey / 10 + 1;
            }
        }


        return answer;
    }
}