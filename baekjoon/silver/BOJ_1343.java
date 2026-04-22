/**
 * 문제
 * 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
 * 이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.
 * 폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.
 *
 * 출력
 * 첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.
 *
 * 메모리 KB
 * 시간 ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1343 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] board;

    public void input() throws IOException {
        String text = br.readLine();
        board = text.split("\\.");
    }

    public void changePolyomino() {
        String result ="";
        for (int i=0;i< board.length; i++) {
            int size = board[i].length();
            if (size % 2 ==0 && size != 0) { // 짝수면 AAAA, BB로 덮을 수 있음
                if (size / 4 > 0) {
                    int iterator = size / 4; // 1, 2, 3 AAAA, AAAAAAAA
                    for (int k=0; k<iterator; k++) {
                        //System.out.print("AAAA");
                        result += "AAAA";
                    }
                    int leftIterator = size - 4*iterator;
                    for (int k=0; k<leftIterator-1; k++) {
                        //System.out.print("BB");
                        result += "BB";
                    }
                }
                else
                    result += "BB";
            } else if (size == 0) {
                //System.out.print(".");
                result += ".";
            }
            else {
                System.out.println(-1);
                return;
            }
            if (i != board.length - 1 && size != 0) {
                //System.out.print("."); // 구분자로 인해 빠진 . 무조건 1개 추가
                result += ".";
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1343 boj1343 = new BOJ_1343();
        boj1343.input();
        boj1343.changePolyomino();
    }
}