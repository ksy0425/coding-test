/*
Programmers Level 2
달리기 경주
연습 문제
 */

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;

        Map<String, Integer> rankMap = new HashMap<>();
        for (int i=0;i<players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (String name : callings) {
            int currentRank = rankMap.get(name);
            if (currentRank > 0) {
                String frontPlayer = players[currentRank-1];
                players[currentRank-1] = name;
                players[currentRank] = frontPlayer;

                rankMap.put(name, currentRank-1);
                rankMap.put(frontPlayer, currentRank);
            }
        }

        return answer;
    }
}