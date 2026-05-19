/*
Programmers Level 1
배열 조각하기
배열 조작 문제
 */

class Solution {
    public int[] solution(int[] arr, int[] query) {

        for (int i=0;i<query.length;i++) {

            if (i%2==0) {
                arr = backCut(arr, query, i);
            }
            else {
                arr = frontCut(arr, query, i);
            }

        }

        int[] answer = new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            answer[i] = arr[i];
        }

        return answer;
    }

    public int[] backCut(int[] arr, int[] query, int k) {
        int len = query[k] + 1;
        if (len > arr.length)
            len = arr.length;

        int[] result = new int[len];
        for (int i=0;i<len;i++) {
            result[i] = arr[i];
        }

        return result;
    }

    public int[] frontCut(int[] arr, int[] query, int k) {
        int[] result = new int[arr.length - query[k]];

        for (int i=query[k];i<arr.length;i++) {
            result[i-query[k]] = arr[i];
        }

        return result;
    }
}