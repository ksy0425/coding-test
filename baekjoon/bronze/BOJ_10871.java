/*
 * 문제
 * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
 *
 * 둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
 *
 * 출력
 * X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
 *
 * 메모리 17800KB
 * 시간 284ms
 */

import java.io.*;
import java.util.*;

public class BOJ_10871 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int numCount;
    private int target;
    private int[] compareNums;

    public void input() throws IOException {
        String input = br.readLine();
        String[] inputNum = input.split(" ");
        numCount = Integer.parseInt(inputNum[0]);
        target = Integer.parseInt(inputNum[1]);

        inputNumber(numCount);
    }

    public void inputNumber(int numCount) throws IOException {
        String input = br.readLine();
        String[] inputNum = input.split(" ");
        compareNums = new int[numCount];

        for (int i=0;i<numCount;i++) {
            compareNums[i] = Integer.parseInt(inputNum[i]);
        }
    }

    public void compare() {

        for (int i=0;i<compareNums.length; i++) {
            if (target > compareNums[i])
                System.out.print(compareNums[i] + " ");
        }

    }

    public static void main(String[] args) throws IOException {
        BOJ_10871 boj10871 = new BOJ_10871();
        boj10871.input();
        boj10871.compare();
    }
}