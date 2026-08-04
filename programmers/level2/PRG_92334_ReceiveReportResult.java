/*
Programmers Level 2
신고 결과 받기
2022 KAKAO BLIND RECRUITMENT 문제
 */

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Set<String>> map = new HashMap<>();
        for (int i=0;i<report.length;i++) {
            String[] reportHistory = report[i].split(" ");
            map.putIfAbsent(reportHistory[1], new HashSet<>());
            map.get(reportHistory[1]).add(reportHistory[0]);
        }

        // 신고당한 사람별 신고자 수 확인
        for (int i = 0; i < id_list.length; i++) {
            String reported = id_list[i];

            if (map.containsKey(reported) && map.get(reported).size() >= k) {
                // 해당 사용자를 신고한 사람들에게 메일
                for (String reporter : map.get(reported)) {
                    for (int j = 0; j < id_list.length; j++) {
                        if (id_list[j].equals(reporter)) {
                            answer[j]++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}