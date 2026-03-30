import java.io.*;
import java.util.*;

public class BOJ_9498 {

    private int examScore;

    public BOJ_9498() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        examScore = sc.nextInt();
    }

    public void output() {
        if (examScore >= 90 && examScore <= 100) {
            System.out.println("A");
        } else if (examScore >= 80 && examScore <= 89) {
            System.out.println("B");
        } else if (examScore >= 70 && examScore <= 79) {
            System.out.println("C");
        } else if (examScore >= 60 && examScore <= 69) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }

    public static void main(String[] args) {
        BOJ_9498 boj_9498 = new BOJ_9498();
        boj_9498.input();
        boj_9498.output();
    }
}