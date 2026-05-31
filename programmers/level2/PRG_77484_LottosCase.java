/*
Programmers Level 2
로또의 최고 순위와 최저 순위
switch case활용 및 조건, 반복문 문제
 */

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int matchingCount = 0;
        int unknownNum = 0;

        for (int i=0;i<lottos.length;i++) {
            if (lottos[i] == 0)
                unknownNum++;
            else {
                for (int k=0;k<win_nums.length;k++) {
                    if (lottos[i]==win_nums[k])
                        matchingCount++;
                }
            }
        }

        answer[0] = matchingCount + unknownNum;
        answer[1] = matchingCount;

        for (int i=0;i<answer.length;i++) {
            switch (answer[i]) {
                case 2: answer[i] = 5; break;
                case 3: answer[i] = 4; break;
                case 4: answer[i] = 3; break;
                case 5: answer[i] = 2; break;
                case 6: answer[i] = 1; break;
                default: answer[i] = 6;
            }
        }

        return answer;
    }
}