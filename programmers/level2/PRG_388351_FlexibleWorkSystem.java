/*
Programmers Level 2
유연근무제
2025 프로그래머스 코드챌린지 1차 예선 문제
 */

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i=0;i<schedules.length; i++) {
            if (checkTimelogs(schedules[i], timelogs[i], startday))
                answer++;
        }

        return answer;
    }

    public boolean checkTimelogs(int schedules, int[] timelogs, int startday) {
        int standard = schedules + 10;
        if (standard % 100 >= 60) {
            standard = 100 * (standard / 100 + 1) + (standard % 10);
        }

        for (int i=0;i<timelogs.length; i++) {
            if (startday > 5) { // 지각 (주말은 제외해야함)
                if (startday == 7) {
                    startday = 0;
                }
                startday++;
                continue;
            }
            if (standard < timelogs[i])
                return false;
            startday++;
        }
        return true;
    }
}