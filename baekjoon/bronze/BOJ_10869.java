/*
 * 문제
 * 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
 *
 * 출력
 * 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
 */

import java.io.*;
import java.util.*;

public class BOJ_10869 {

    private BufferedReader br;
    private int[] numbers;

    public BOJ_10869() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void inputNumber() throws IOException {
        String input = br.readLine();
        String[] inputNum = input.split(" ");

        numbers = new int[inputNum.length];

        for (int i = 0; i < inputNum.length; i++) {
            numbers[i] = Integer.parseInt(inputNum[i]);
        }
    }

    public void add() {
        System.out.println(numbers[0] + numbers[1]);
    }

    public void minus() {
        System.out.println(numbers[0] - numbers[1]);
    }

    public void multiply() {
        System.out.println(numbers[0] * numbers[1]);
    }

    public void divide() {
        System.out.println(numbers[0] / numbers[1]);
    }

    public void remain() {
        System.out.println(numbers[0] % numbers[1]);
    }

    public void output() {
        add();
        minus();
        multiply();
        divide();
        remain();
    }

    public static void main(String[] args) throws IOException {
        BOJ_10869 boj10869 = new BOJ_10869();
        boj10869.inputNumber();
        boj10869.output();
    }
}