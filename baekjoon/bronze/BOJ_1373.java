/*
 * 문제
 * 2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.
 *
 * 출력
 * 첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
 *
 * 메모리 90420KB
 * 시간 1956ms
 */

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class BOJ_1373 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String text;
    private BigInteger num;

    public void input() throws IOException {
        text = br.readLine();
        num = new BigInteger(text, 2);
    }

    public void transform() {
        String octal = num.toString(8);
        System.out.println(octal);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1373 boj1373 = new BOJ_1373();
        boj1373.input();
        boj1373.transform();
    }
}