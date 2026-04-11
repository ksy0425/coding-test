/*
 * 문제
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * 출력
 * 주어진 수들 중 소수의 개수를 출력한다.
 *
 * 메모리 14148KB
 * 시간 104ms
 */

import java.io.*;

public class BOJ_1978 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int testNum;
    private String[] num;

    public void input() throws IOException {
        testNum = Integer.parseInt(br.readLine());
        num = br.readLine().split(" ");
    }

    public boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void find() {
        int count = 0;

        for (int i = 0; i < testNum; i++) {
            int num = Integer.parseInt(this.num[i]);

            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1978 boj1978 = new BOJ_1978();
        boj1978.input();
        boj1978.find();
    }
}