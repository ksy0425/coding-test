/*
 * 문제
 * 다섯 개의 자연수가 있다. 이 수의 적어도 대부분의 배수는 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수이다.
 * 서로 다른 다섯 개의 자연수가 주어질 때, 적어도 대부분의 배수를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 다섯 개의 자연수가 주어진다. 100보다 작거나 같은 자연수이고, 서로 다른 수이다.
 *
 * 출력
 * 첫째 줄에 적어도 대부분의 배수를 출력한다.
 *
 * 메모리 14308KB
 * 시간 128ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1145 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int[] naturalNum =new int[5];

    public void inputNaturalNum() throws IOException {
        String[] textNum = br.readLine().split(" ");
        for (int i=0;i< naturalNum.length;i++) {
            naturalNum[i] = Integer.parseInt(textNum[i]);
        }
    }

    public void findAtLeastMultiples() {
        int result = getMin();
        int count = 0;

        while (true) {
            for (int i=0; i< naturalNum.length; i++) {
                if (result % naturalNum[i] == 0)
                    count++;
            }

            if(count >= 3) {
                break;
            }
            else {
                count = 0;
                result++;
            }

        }

        System.out.println(result);
    }

    public int getMin() {
        int min = naturalNum[0];
        for (int i=0;i< naturalNum.length;i++) {
            if (min>naturalNum[i])
                min = naturalNum[i];
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BOJ_1145 boj1145 = new BOJ_1145();
        boj1145.inputNaturalNum();
        boj1145.findAtLeastMultiples();
    }
}