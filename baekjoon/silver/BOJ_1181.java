/*
 * 문제
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 *
 * 입력
 * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
 *
 * 출력
 * 조건에 따라 정렬하여 단어들을 출력한다.
 *
 * 메모리 KB
 * 시간 ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1181 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int inputNum;
    private String[] word;

    public void input() throws IOException {
        inputNum = Integer.parseInt(br.readLine());
        word = new String[inputNum];
    }

    public void inputWord() throws IOException {
        for (int i=0;i<inputNum;i++) {
            word[i] = br.readLine();
        }
    }

    public List<String> compare() {
        // 중복 제거: Set 사용
        Set<String> set = new HashSet<>(Arrays.asList(word));
        List<String> list = new ArrayList<>(set);

        // 정렬 기준: 길이 → 사전순
        list.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });

        return list;
    }

    public void print(List<String> list) {
        for (String text : list) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ_1181 boj1181 = new BOJ_1181();
        boj1181.input();
        boj1181.inputWord();
        List<String> result = boj1181.compare();
        boj1181.print(result);
    }
}