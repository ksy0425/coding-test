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
 * 메모리 KB
 * 시간 ms
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

    public void lcm() {
        int result = 0;
        if (num[0]==1 || num[1]==1) {
            result = num[0]*num[1];
        }
        else {
            int[] numList = new int[num[1]]; //numList인데스 0~9
            for (int i=1;i<=num[1];i++) {
                numList[i-1] = num[0]*i; // 넘리[0] = 6x1, 넘리[9] = 6x10, 넘리[4]=30
            }
            for (int i=1;i<=num[0];i++) {
                for (int k=0;k<numList.length;k++) {
                    if (num[1]*i == numList[k]) {
                        result = numList[k];
                        break;
                    }
                }
                if (result != 0)
                    break;
                 //넘리[0] == 10x1, 넘리[5] == 10x6, 넘리[4]==10x5
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1934 boj1934 = new BOJ_1934();
        boj1934.input();
        boj1934.inputNum();
    }
}