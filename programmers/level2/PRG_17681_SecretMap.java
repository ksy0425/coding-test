/*
Programmers Level 2 [2018 KAKAO BLIND RECRUITMENT]
[1차] 비밀지도
비트 OR 연산
 */

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binary = String.format("%" + n + "s",
                            Integer.toBinaryString(arr1[i] | arr2[i]))
                    .replace(' ', '0');

            answer[i] = binary
                    .replace('1', '#')
                    .replace('0', ' ');
        }

        return answer;
    }
}