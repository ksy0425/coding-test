/*
 * 문제
 * 피제수(분자) A와 제수(분모) B가 있다. 두 수를 나누었을 때, 소숫점 아래 N번째 자리수를 구하려고 한다. 예를 들어, A=3, B=4, N=1이라면, A÷B=0.75 이므로 출력 값은 7이 된다.
 *
 * 입력
 * 첫 번째 줄에 A와 B(1 ≤ A, B ≤ 100,000), N(1 ≤ N ≤ 1,000,000)이 공백을 경계로 주어진다.
 *
 * 출력
 * A÷B를 했을 때, 소숫점 아래 N번째 수를 출력한다.
 *
 * 메모리 14292KB
 * 시간 112ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1312 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int numerator;
    private int denominator;
    private int digitAfterDecimal;

    public void input() throws IOException {
        String inputText = br.readLine();
        typeConversion(inputText);
    }

    public void typeConversion(String text) {
        String[] nums = text.split(" ");
        numerator = Integer.parseInt(nums[0]);
        denominator = Integer.parseInt(nums[1]);
        digitAfterDecimal = Integer.parseInt(nums[2]);
    }

    public void calcDevide() {
        int remainder = numerator % denominator;
        int result = 0;

        for (int i = 0; i < digitAfterDecimal; i++) { //나머지 계속 나누기 n번째 소수점까지
            remainder *= 10;
            result = remainder / denominator;
            remainder %= denominator;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1312 boj1312 = new BOJ_1312();
        boj1312.input();
        boj1312.calcDevide();
    }
}