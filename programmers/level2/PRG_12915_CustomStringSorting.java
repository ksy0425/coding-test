/*
Programmers Level 2
문자열 내 마음대로 정렬하기
정렬 및 비교 문제
 */

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        for (int i=1;i<strings.length;i++) {
            char[] chars1 = strings[i-1].toCharArray();
            char[] chars2 = strings[i].toCharArray();

            if (chars1[n] > chars2[n] ||
                    (chars1[n] == chars2[n] && strings[i-1].compareTo(strings[i]) > 0)) {
                String temp = strings[i-1];
                strings[i-1] = strings[i];
                strings[i] = temp;
            }

            for (int k=i-1;k>0;k--) {
                chars1 = strings[k].toCharArray();
                chars2 = strings[k-1].toCharArray();

                if (chars2[n] > chars1[n] ||
                        (chars2[n] == chars1[n] && strings[k-1].compareTo(strings[k]) > 0)) {
                    String temp = strings[k-1];
                    strings[k-1] = strings[k];
                    strings[k] = temp;
                }
            }
        }

        for (int i=0;i<answer.length;i++) {
            answer[i] = strings[i];
        }

        return answer;
    }
}