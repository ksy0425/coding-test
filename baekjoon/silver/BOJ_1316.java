/*
 * 문제
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 *
 * 출력
 * 첫째 줄에 그룹 단어의 개수를 출력한다.
 *
 * 메모리 14240KB
 * 시간 104ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1316 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int testNum;
    private String[] word;

    public void inputTestNum() throws IOException {
        testNum = Integer.parseInt(br.readLine());
        word = new String[testNum];
    }

    public void inputWord() throws IOException {
        for (int i=0;i<testNum; i++) {
            word[i] = br.readLine();
        }
    }

    public void groupWordsChecker() {
        int checkCount = 0;

        for (int i=0;i<testNum;i++) { // 단어 수 만큼

            boolean[] visited = new boolean[26]; // check값 넣어 놓을 배열
            boolean isGroupWord = true; // flag값? 이라고 생각
            char prev = 0; // 이전 문자 역할 해줄거임

            for (int k=0;k<word[i].length();k++) { // 각 단어의 길이 만큼
                char appearedChar = word[i].charAt(k); // 해당 단어의 문자들

                if (appearedChar != prev) { // 지금 문자를 이전 문자랑 비교
                    if (visited[appearedChar - 'a']) { // 이미 나온적 있네
                        isGroupWord = false;
                        break;
                    }
                    visited[appearedChar - 'a'] = true;
                }
                prev = appearedChar;

            }

            if (isGroupWord)
                checkCount++;
        }
        System.out.println(checkCount);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1316 boj1316 = new BOJ_1316();
        boj1316.inputTestNum();
        boj1316.inputWord();
        boj1316.groupWordsChecker();
    }
}