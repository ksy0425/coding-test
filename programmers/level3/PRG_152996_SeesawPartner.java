/*
Programmers Level 3
시소 짝궁
연습 문제
 */

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // 몸무게별 사람 수
        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        // 몸무게 종류별로 한 번씩만 확인
        for (int weight : map.keySet()) {

            long count = map.get(weight);

            // 1. 같은 몸무게
            answer += count * (count - 1) / 2;

            // 2. 1 : 2
            int target = weight * 2;

            if (map.containsKey(target)) {
                answer += count * map.get(target);
            }

            // 3. 2 : 3
            if (weight * 3 % 2 == 0) {
                target = weight * 3 / 2;

                if (map.containsKey(target)) {
                    answer += count * map.get(target);
                }
            }

            // 4. 3 : 4
            if (weight * 4 % 3 == 0) {
                target = weight * 4 / 3;

                if (map.containsKey(target)) {
                    answer += count * map.get(target);
                }
            }
        }

        return answer;
    }
}