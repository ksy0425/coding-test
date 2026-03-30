import java.io.*;
import java.util.*;

public class BOJ_9086 {

    /*
     * 문제
     * 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다. 문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.
     *
     * 출력
     * 각 테스트 케이스에 대해서 주어진 문자열의 첫 글자와 마지막 글자를 연속하여 출력한다.
     *
     */
    
    private Scanner sc;
    private int testCase;
    private String text;
    private char firstChar;
    private char lastChar;
    
    public void inputTestCase() {
        sc = new Scanner(System.in);
        testCase = sc.nextInt();
    }

    public void firstCharLastChar(String inputText) {
        firstChar = inputText.charAt(0);
        lastChar = inputText.charAt(inputText.length()-1);
        output();
    }

    public void inputText(int testCase) {
        for (int i=0; i<testCase; i++) {
            text = sc.next();
            firstCharLastChar(text);
        }
    }

    public void output() {
        System.out.printf("%c%c\n", firstChar, lastChar);
    }

    public int getTestCase() {
        return testCase;
    }

    public static void main(String[] args) {
        BOJ_9086 boj_9086 = new BOJ_9086();
        boj_9086.inputTestCase();
        boj_9086.inputText(boj_9086.getTestCase());
    }
}