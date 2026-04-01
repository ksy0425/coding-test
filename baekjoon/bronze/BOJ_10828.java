/*
 * 문제
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 다섯 가지이다.
 *
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 입력
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 *
 * 출력
 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

import java.io.*;
import java.util.*;

public class BOJ_10828 {

    private Scanner sc;
    private ArrayList<Integer> stack;
    private int testCase;
    private int stackPointer;

    public BOJ_10828() {
        sc = new Scanner(System.in);
        stack = new ArrayList<>();
        stackPointer = -1;
    }

    public void inputTestCase() {
        testCase = sc.nextInt();
    }

    public void push(int x) {
        stack.add(x);
        stackPointer++;
    }

    public void pop() {
        if (stackPointer == -1)
            System.out.println(stackPointer);
        else {
            int popNum = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            stackPointer--;
            System.out.println(popNum);
        }
    }

    public void size() {
        System.out.println(stack.size());
    }

    public void empty() {
        if (stackPointer == -1)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public void top() {
        if (stackPointer == -1)
            System.out.println(stackPointer);
        else
            System.out.println(stack.get(stack.size() - 1));
    }

    public void test() {
        for (int i=0;i<testCase;i++) {
            String order = sc.next();

            if (order.equals("push"))
                push(sc.nextInt());

            else {
                int result;

                switch (order) {
                    case "pop": pop(); break;
                    case "size": size(); break;
                    case "empty": empty(); break;
                    case "top": top(); break;
                    default: break;
                }
            }
        }
    }

    public static void main(String[] args) {
        BOJ_10828 boj_10828 = new BOJ_10828();
        boj_10828.inputTestCase();
        boj_10828.test();
    }
}