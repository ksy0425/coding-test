/*
Programmers Level 2
옹알이(2)
옹알이 + 중복 된거 체크 문제
 */

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] canSpeak = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {

            for (String s : canSpeak) {
                if (word.contains(s+s)) {
                    break;
                }
                else {
                    word = word.replace(s, " ");
                }
            }

            if (word.trim().equals("")) {
                answer++;
            }
        }

        return answer;
    }
}