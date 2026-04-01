/*
 * 문제
 * 자연수 N이 주어진다. N을 이진수로 바꿔서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000,000,000,000)
 *
 * 출력
 * N을 이진수로 바꿔서 출력한다. 이진수는 0으로 시작하면 안 된다.
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class BOJ_10829 {

    private Scanner sc;
    private BigInteger inputNum;
    private String binary;

    public BOJ_10829() {
        sc = new Scanner(System.in);
    }

    public void input() {
        inputNum = sc.nextBigInteger();
    }

    public void binaryTransform() {
        binary = inputNum.toString(2);
    }

    public void output() {
        System.out.println(binary);
    }

    public static void main(String[] args) {
        BOJ_10829 boj_10829 = new BOJ_10829();
        boj_10829.input();
        boj_10829.binaryTransform();
        boj_10829.output();
    }
}