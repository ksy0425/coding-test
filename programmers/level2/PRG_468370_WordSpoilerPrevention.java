/*
Programmers Level 2
중요한 단어를 스포 방지
2025 카카오 하반기 1차 문제
 */

import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        // 단어의 [시작 인덱스, 끝 인덱스]
        ArrayList<int[]> wordRanges = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        // 1. message에서 단어와 위치를 찾는다.
        int start = -1;

        for (int i = 0; i < message.length(); i++) {

            if (message.charAt(i) != ' ') {

                if (start == -1) {
                    start = i;
                }

            } else {

                if (start != -1) {
                    int end = i - 1;

                    wordRanges.add(new int[]{start, end});
                    words.add(message.substring(start, end + 1));

                    start = -1;
                }
            }
        }

        // 마지막 단어 처리
        if (start != -1) {
            int end = message.length() - 1;

            wordRanges.add(new int[]{start, end});
            words.add(message.substring(start, end + 1));
        }


        // 2. 스포일러가 아닌 일반 영역에 등장한 단어들을 저장
        HashSet<String> normalWords = new HashSet<>();

        for (int i = 0; i < wordRanges.size(); i++) {

            int wordStart = wordRanges.get(i)[0];
            int wordEnd = wordRanges.get(i)[1];

            boolean isSpoilerWord = false;

            for (int[] range : spoiler_ranges) {

                int spoilerStart = range[0];
                int spoilerEnd = range[1];

                // 단어와 스포일러 구간이 겹치는 경우
                if (wordStart <= spoilerEnd && wordEnd >= spoilerStart) {
                    isSpoilerWord = true;
                    break;
                }
            }

            // 어떤 스포일러 구간과도 겹치지 않았다면 일반 단어
            if (!isSpoilerWord) {
                normalWords.add(words.get(i));
            }
        }


        // 3. 이미 중요한 단어로 처리한 단어
        HashSet<String> checkedWords = new HashSet<>();


        // 4. 스포일러 구간을 왼쪽부터 하나씩 연다.
        for (int[] range : spoiler_ranges) {

            int spoilerStart = range[0];
            int spoilerEnd = range[1];

            // 현재 스포일러 구간과 겹치는 단어 찾기
            for (int i = 0; i < wordRanges.size(); i++) {

                int wordStart = wordRanges.get(i)[0];
                int wordEnd = wordRanges.get(i)[1];

                // 단어와 스포일러 구간이 겹치지 않는 경우
                if (wordEnd < spoilerStart || wordStart > spoilerEnd) {
                    continue;
                }

                String word = words.get(i);

                // 일반 영역에 등장한 단어라면 중요한 단어가 아님
                if (normalWords.contains(word)) {
                    continue;
                }

                // 이미 중요한 단어로 처리했다면 중복
                if (checkedWords.contains(word)) {
                    continue;
                }

                // 중요한 단어
                answer++;
                checkedWords.add(word);
            }
        }

        return answer;
    }
}