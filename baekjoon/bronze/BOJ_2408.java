/**
 * 문제
 * 어떤 임의의 수식이 입력으로 들어올때 수식을 계산하는 프로그램을 짜시오. 수의 크기는 -10의100승 이상 10의100승 이하이고, 수식에 괄호는 없다.
 * 소수점이 나올 경우, 소수점은 내린다. 참고로, -5/2 = -3이고, 5/-2도 -3이다. -5/-2는 2이다.
 * 입력
 * 수의 개수 N(1 ≤ N ≤ 10) 이 주어지고 다음 2N-1 개의 줄에는 수와 연산자(+, -, *, /) 가 번갈아서 들어온다.
 *
 * 출력
 * 첫째 줄에 계산이 끝난 후 수를 출력한다.
 */

import java.io.*;
import java.util.*;

public class BOJ_2408 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int numberCount;
    private int[] number;
    private String[] operator;

    public void inputNumberCount() throws IOException {
        numberCount = Integer.parseInt(br.readLine());
        number = new int[numberCount];
        operator = new String[numberCount-1];
    }

    public void inputNumAndOperator() throws IOException {
        for (int i=0;i< operator.length;i++) {
            number[i] = Integer.parseInt(br.readLine());
            operator[i] = br.readLine();
        }

        number[number.length-1] = Integer.parseInt(br.readLine());
    }

    public void calc() {
        long result = number[0];
        for (int i=0;i<numberCount-1;i++) {
            switch (operator[i]) {
                case "+": result += number[i+1]; break;
                case "-": result -= number[i+1]; break;
                case "*": result *= number[i+1]; break;
                case "/": result /= number[i+1]; break;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ_2408 boj2408 = new BOJ_2408();
        boj2408.inputNumberCount();
        boj2408.inputNumAndOperator();
        boj2408.calc();
    }
}