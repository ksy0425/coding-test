/*
Programmers Level 2
대충 만든 자판
해시맵 사용 문제
 */

import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0;i<keymap.length;i++) {
            char[] temp = keymap[i].toCharArray();
            for (int k=0;k<temp.length;k++) {
                char c = temp[k];

                if (!map.containsKey(c) || map.get(c) > k+1)
                    map.put(c, k+1);
            }
        }

        for (int i=0;i<targets.length;i++) {
            int sum = 0;
            boolean possible = true;

            char[] target = targets[i].toCharArray();

            for (int k =0;k<target.length;k++) {
                if (!map.containsKey(target[k])) {
                    possible = false;
                    break;
                }

                sum += map.get(target[k]);
            }

            answer[i] = possible ? sum : -1;
        }

        return answer;
    }
}