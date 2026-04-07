/*
 * 문제
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 *
 * 입력
 * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 *
 * 메모리 14244KB
 * 시간 104ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1427 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Integer> inputNum = new ArrayList<>();
    private char[] numbers;

    public void input() throws IOException {
        String sNum = br.readLine();
        numbers = sNum.toCharArray();
    }

    public void sort() {
        Arrays.sort(numbers);

        for(int i= numbers.length-1; i>=0;i--) {
            System.out.print(numbers[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        BOJ_1427 boj1427 = new BOJ_1427();
        boj1427.input();
        boj1427.sort();
    }
}