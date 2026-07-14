/*
Programmers Level 2
크레인 인형뽑기 게임
2019 카카오 개발자 겨울 인턴십 문제
 */

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int[] bucket = new int[board.length*board.length];
        int bucketIndex = -1;
        for (int i=0; i<moves.length; i++) {
            int idx1 = 0;
            while (idx1 < board.length && board[idx1][moves[i]-1] == 0) {
                idx1++;
            }
            if (idx1 == board.length)
                continue;
            bucket[++bucketIndex] = board[idx1][moves[i]-1];
            board[idx1][moves[i]-1] = 0;

            System.out.println(bucket[bucketIndex]);

            if (bucketIndex>0 && bucket[bucketIndex] == bucket[bucketIndex-1]) {
                answer += 2;
                bucket[bucketIndex] = 0;
                bucket[bucketIndex-1] = 0;
                bucketIndex -= 2;
            }
        }

        return answer;
    }
}