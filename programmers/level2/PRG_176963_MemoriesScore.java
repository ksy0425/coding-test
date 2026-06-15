/*
Programmers Level 2
추억 점수
3중 반복 문제
 */

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for (int i=0;i<photo.length; i++) {
            for (int k=0; k<photo[i].length; k++) {
                for (int j=0; j<name.length; j++) {
                    if (name[j].equals(photo[i][k]))
                        answer[i] += yearning[j];
                }
            }
        }

        return answer;
    }
}