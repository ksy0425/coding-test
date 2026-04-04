/*
 * 문제
 * 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여덟 가지이다.
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * 입력
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 *
 * 출력
 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

import java.io.*;
import java.util.*;

public class BOJ_10866 {

    private BufferedReader br;
    private int orderCount;
    private ArrayList<Integer> deque;

    public BOJ_10866() {
        br = new BufferedReader(new InputStreamReader(System.in));
        deque = new ArrayList<>();
    }

    public void inputOrderCount() throws IOException {
        orderCount = Integer.parseInt(br.readLine());
    }

    public void order() throws IOException {
        for (int i=0;i<orderCount; i++) {
            String[] orderPart = br.readLine().split(" ");

            switch (orderPart[0]) {
                case "push_front": push_front(Integer.parseInt(orderPart[1])); break;
                case "push_back": push_back(Integer.parseInt(orderPart[1])); break;
                case "pop_front": pop_front(); break;
                case "pop_back": pop_back(); break;
                case "size": System.out.println(deque.size()); break;
                case "empty": empty(); break;
                case "front": front(); break;
                case "back": back(); break;
            }
        }
    }

    public void push_front(int x) {
        deque.add(0, x);
    }

    public void push_back(int x) {
        if (deque.isEmpty())
            deque.add(0, x);
        else
            deque.add(deque.size()-1, x);
    }

    public void pop_front() {
        front();
        if (!deque.isEmpty())
            deque.remove(0);
    }

    public void pop_back() {
        back();
        if (!deque.isEmpty())
            deque.remove(deque.size()-1);
    }

    public void empty() {
        if (deque.size() != 0)
            System.out.println(0);
        else
            System.out.println(1);
    }

    public void front() {
        if (deque.isEmpty())
            System.out.println(-1);
        else
            System.out.println(deque.get(0));
    }

    public void back() {
        if (deque.isEmpty())
            System.out.println(-1);
        else
            System.out.println(deque.get(deque.size() - 1));
    }

    public static void main(String[] args) throws IOException {
        BOJ_10866 boj10866 = new BOJ_10866();
        boj10866.inputOrderCount();
        boj10866.order();
    }
}