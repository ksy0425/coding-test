/*
Programmers Level 1
안전 지대
이차원 배열, 경계 탐색
 */

class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int[][] copyBoard = boardCopy(board);
        if (board.length==1 && board[0][0] ==1)
            return answer;
        else if (board.length==1 && board[0][0] !=1)
            return ++answer;
        else {
            for (int i=0;i<board.length;i++) {
                for (int k=0;k<board[i].length;k++) {
                    if (copyBoard[i][k] == 1) {
                        if (i>0 && i<board.length-1 && k>0 && k<board[i].length-1) {
                            board = upLine(i,k,board);
                            board = sideLine(i, k, board);
                            board = underLine(i, k, board);

                        } else if (i==0) {
                            if (k==0) {
                                board[i][k+1] = 1;
                                board[i+1][k] = 1;
                                board[i+1][k+1] = 1;
                            } else if (k==board[i].length-1) {
                                board[i][k-1] = 1;
                                board[i+1][k] = 1;
                                board[i+1][k-1] = 1;
                            } else {
                                board = sideLine(i, k, board);
                                board = underLine(i, k, board);
                            }
                        } else if (i==board.length-1) {
                            if (k==0) {
                                board[i-1][k] = 1;
                                board[i][k+1] = 1;
                                board[i-1][k+1] = 1;
                            } else if (k==board[i].length-1) {
                                board[i][k-1] = 1;
                                board[i-1][k] = 1;
                                board[i-1][k-1] = 1;
                            } else {
                                board = upLine(i,k,board);
                                board = sideLine(i, k, board);
                            }
                        } else if (k==0 && i>0 && i<board.length-1) {
                            board[i-1][k] = 1;
                            board[i-1][k+1] = 1;
                            board[i][k+1] = 1;
                            board[i+1][k] = 1;
                            board[i+1][k+1] = 1;
                        } else if (k==board[i].length-1 && i>0 && i<board.length-1) {
                            board[i-1][k] = 1;
                            board[i-1][k-1] = 1;
                            board[i][k-1] = 1;
                            board[i+1][k] = 1;
                            board[i+1][k-1] = 1;
                        }

                    }
                }
            }
            answer = safeSeatCount(board);
        }


        return answer;
    }

    public int[][] upLine(int i, int k, int[][] board) {
        board[i-1][k-1] = 1;
        board[i-1][k] = 1;
        board[i-1][k+1] = 1;
        return board;
    }

    public int[][] sideLine(int i, int k, int[][] board) {
        board[i][k-1] = 1;
        board[i][k+1] = 1;
        return board;
    }

    public int[][] underLine(int i, int k, int[][] board) {
        board[i+1][k-1] = 1;
        board[i+1][k] = 1;
        board[i+1][k+1] = 1;
        return board;
    }

    public int[][] boardCopy(int[][] board) {
        int[][] copyBoard = new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            for (int k=0;k<board[i].length;k++) {
                copyBoard[i][k] = board[i][k];
            }
        }
        return copyBoard;
    }

    public int safeSeatCount(int[][] board) {
        int result =0;
        for (int i=0;i<board.length;i++) {
            for (int k=0;k<board[i].length;k++) {
                if (board[i][k] == 0)
                    result++;
            }
        }
        return result;
    }
}