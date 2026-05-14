/*
Programmers Level 1
특이한 정렬
정렬(반복문, 배열) 문제
 */

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];

        int[] temp = new int[10001];

        for (int i = 0; i < numlist.length; i++) {
            temp[numlist[i]] = 1;
        }

        int i = -1;
        int j = n;
        int k = n;

        while (j < 10001 || k >= 0) {

            if (j < 10001 && temp[j] == 1) {
                answer[++i] = j;
            }

            if (k >= 0) {
                if (temp[k] == 1 && j != n) {
                    answer[++i] = k;
                }
                k--;
            }

            j++;
        }

        return answer;
    }
}