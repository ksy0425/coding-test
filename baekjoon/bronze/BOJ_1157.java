/*
 * 문제
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 *
 * 입력
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 *
 * 출력
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 *
 * 메모리 21120KB
 * 시간 248ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1157 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String word;

    public void input() throws IOException {
        word = br.readLine().toUpperCase();
    }

    public void mostWord() {
        int[] counts = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            counts[ch - 'A']++;
        }

        int max = 0;
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (counts[i] > max) {
                max = counts[i];
                result = (char) (i + 'A');
            } else if (counts[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1157 boj1157 = new BOJ_1157();
        boj1157.input();
        boj1157.mostWord();
    }
}