/*
 * 문제
 * 오세준은 어떤 자연수의 소인수중 최댓값이 K보다 크지 않을때 그 수를 K-세준수라고 부른다.
 * N보다 작거나 같은 자연수 중에 K-세준수가 총 몇 개인지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N, 둘째 줄에 K가 주어진다. N은 100,000보다 작거나 같은 자연수이고, K는 100보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 N보다 작거나 같은 K-세준수가 몇 개인지 출력한다.
 *
 * 메모리 14172KB
 * 시간 140ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1418 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int naturalNumber;
    private int maxNumber;

    public void inputNumber() throws IOException {
        naturalNumber = Integer.parseInt(br.readLine());
    }

    public void inputMaxNumber() throws IOException {
        maxNumber = Integer.parseInt(br.readLine());
    }

    public void findKPrimeFactor() {
        int count = 0;

        for (int i = 1; i <= naturalNumber; i++) {
            if (isKSejunNumber(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public boolean isKSejunNumber(int number) {
        int temp = number;

        for (int i = 2; i * i <= temp; i++) {
            while (temp % i == 0) {
                if (i > maxNumber) {
                    return false;
                }
                temp /= i;
            }
        }

        if (temp > 1 && temp > maxNumber) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ_1418 boj1418 = new BOJ_1418();
        boj1418.inputNumber();
        boj1418.inputMaxNumber();
        boj1418.findKPrimeFactor();
    }
}