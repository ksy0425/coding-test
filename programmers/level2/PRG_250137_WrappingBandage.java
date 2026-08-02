/*
Programmers Level 2
붕대 감기
[PCCP 기출문제] 1번 문제
 */

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량 bandage
        // 최대 체력을 의미하는 health
        // 몬스터의 공격 시간과 피해량 attacks
        int answer = 0;
        int curHealth = health;
        int comboSuccess = 0;
        int attackTimeIndex = 0;
        for(int i=1;i<=attacks[attacks.length-1][0]; i++) { // 마지막 공격 시간까지 돌거임
            if (attacks[attackTimeIndex][0] == i) { // 몬스터 공격
                curHealth -= attacks[attackTimeIndex][1];
                attackTimeIndex++;
                comboSuccess = 0;
                System.out.println(curHealth);
            }

            else { // 풀피가 아닐 때 체력 회복
                curHealth += bandage[1];
                comboSuccess++;
                if (comboSuccess == bandage[0]) {
                    curHealth += bandage[2];
                    comboSuccess = 0;
                }
                if (curHealth > health)
                    curHealth = health;
            }

            if (curHealth <= 0)
                return -1;
        }

        answer = curHealth;

        return answer;
    }
}