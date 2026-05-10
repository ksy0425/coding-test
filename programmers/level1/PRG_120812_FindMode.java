/*
Programmers Level 1
최빈값 구하기
최빈값, 배열 문제
 */

class Solution {
    public int solution(int[] array) {
        int answer = 0;

        int[] arrayCount = new int[1000];
        for (int i=0;i<array.length;i++) {
            arrayCount[array[i]]++;
        }

        int max = arrayCount[0];
        int maxNum = 0;
        for (int i=1;i<arrayCount.length;i++) {
            if (arrayCount[i]>max) {
                max = arrayCount[i];
                maxNum = i;
            }
        }
        int sameMaxCount = 0;
        for (int i=0;i<arrayCount.length;i++) {
            if (arrayCount[i]==max)
                sameMaxCount++;
        }
        if (sameMaxCount == 1)
            answer = maxNum;
        else
            answer=-1;

        return answer;
    }
}