/*
Programmers Level 1
옹알이 (2)
문자열 / 구현
*/
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] canSpeak = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {

            // 발음 제거
            for (String s : canSpeak) {
                word = word.replace(s, " ");
            }

            // 공백만 남으면 발음 가능
            if (word.trim().equals("")) {
                answer++;
            }
        }

        return answer;
    }
}