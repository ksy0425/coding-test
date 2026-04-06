/*
 * 문제
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
 *
 * 출력
 * 첫째 줄에 N!을 출력한다.
 *
 * 메모리 14116KB
 * 시간 104ms
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ_10872 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int target;

    public void input() throws IOException {
        target = Integer.parseInt(br.readLine());
    }

    public void factorial() {
        int result = 1;
        for (int i=1;i<=target;i++) {
            result *= i;
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ_10872 boj10872 = new BOJ_10872();
        boj10872.input();
        boj10872.factorial();
    }
}