/*
Programmers Level 2
카드 뭉치
배열 인덱스 문제
 */

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int cards1Index = 0;
        int cards2Index = 0;
        int i= 0;
        while (i < goal.length) {

            if (cards1Index < cards1.length && cards1[cards1Index].equals(goal[i])) {
                cards1Index++;
                i++;
            }
            else if (cards2Index < cards2.length && cards2[cards2Index].equals(goal[i])) {
                cards2Index++;
                i++;
            }
            else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}