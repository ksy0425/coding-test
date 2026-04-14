/*
 * 문제
 * 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다.
 * 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
 * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
 *
 * 출력
 * 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
 *
 * 첫 채점 결과 -> 시간 초과 발생 (불필요한 배열 생성 및 반복문)
 * 메모리 15220KB
 * 시간 152ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1934 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int testNum;
    private int[] num = new int[2];

    public void input() throws IOException {
        testNum = Integer.parseInt(br.readLine());
    }

    public void inputNum() throws IOException {
        for (int i=0;i<testNum;i++) {
            String[] number = br.readLine().split(" ");
            num[0] = Integer.parseInt(number[0]);
            num[1] = Integer.parseInt(number[1]);
            lcm();
        }
    }

    // 최소공배수 계산
    public void lcm() {
        int gcd = getGCD(num[0], num[1]);
        int result = num[0] * num[1] / gcd;
        System.out.println(result);
    }

    // 최대공약수 계산 (유클리드 호제법)
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BOJ_1934 boj1934 = new BOJ_1934();
        boj1934.input();
        boj1934.inputNum();
    }
}