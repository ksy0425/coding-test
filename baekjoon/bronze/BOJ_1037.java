/*
 * 문제
 * 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다. 둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.
 *
 * 출력
 * 첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
 *
 * 메모리 14220KB
 * 시간 108ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1037 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int divisorCount;
    private int[] divisor;

    public void inputDivisorCount() throws IOException {
        divisorCount = Integer.parseInt(br.readLine());
    }

    public void inputDivisor() throws IOException {
        divisor = new int[divisorCount];
        String[] numberText = br.readLine().split(" ");
        for (int i=0;i<divisorCount;i++) {
            divisor[i] = Integer.parseInt(numberText[i]);
        }
    }

    public void findNumber() {
        int result = 0;
        int maxDivisor = maxDivisor();
        int minDivisor = minDivisor();

        result = maxDivisor * minDivisor;

        System.out.println(result);
    }

    public int maxDivisor() {
        int max = divisor[0];
        for (int i=0;i<divisor.length;i++) {
            if (max < divisor[i])
                max = divisor[i];
        }
        return max;
    }

    public int minDivisor() {
        int min = divisor[0];
        for (int i=0;i<divisor.length;i++) {
            if (min > divisor[i])
                min = divisor[i];
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BOJ_1037 boj1037 = new BOJ_1037();
        boj1037.inputDivisorCount();
        boj1037.inputDivisor();
        boj1037.findNumber();
    }
}