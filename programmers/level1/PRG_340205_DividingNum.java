/*
Programmers Level 1 [PCCE 기출문제] 3번
수 나누기
디버깅 문제
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        while (number!=0){
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);
    }
}