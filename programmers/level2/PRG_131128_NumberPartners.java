/*
Programmers Level 2
숫자 짝궁
연습 문제
 */

// import java.util.*;

// class Solution {
//     public String solution(String X, String Y) {
//         String answer = "";

//         String matchStr = matching(X, Y);
//         // System.out.println(matchStr);

//         if (matchStr.isEmpty())
//             return "-1";
//         else if (Integer.parseInt(matchStr) == 0) {
//             return "0";
//         }
//         else {
//             answer = makeMaxNum(matchStr);
//         }

//         return answer;
//     }

//     public String matching(String x, String y) {
//         String result = "";

//         char[] xChar = x.toCharArray();
//         char[] yChar = y.toCharArray();

//         char[] xResult = new char[10]; // 0~9
//         char[] yResult = new char[10]; // 0~9

//         for (int i=0;i<xChar.length; i++) {
//             xResult[xChar[i] - '0']++;
//         }
//         for (int i=0;i<yChar.length; i++) {
//             yResult[yChar[i] - '0']++;
//         }

//         int i=0;
//         while (i<10) {
//             while (xResult[i] != 0 && yResult[i] != 0) {
//                 xResult[i]--; yResult[i]--;
//                 result += i;
//             }
//             i++;
//         }

//         return result;
//     }

//     public String makeMaxNum(String matchStr) {
//         String result = "";
//         int length = matchStr.length();
//         int matchNum = Integer.parseInt(matchStr);
//         int[] number = new int[length];

//         int iterator = 1;
//         for (int i=1;i<length;i++) {
//             iterator *= 10;
//         }

//         for (int i=0;i<length;i++) {
//             number[i] = matchNum / iterator;
//             matchNum -= number[i]*iterator;
//             iterator /= 10;
//         }

//         Arrays.sort(number);
//         for (int i=0;i<length / 2; i++) {
//             int temp = number[i];
//             number[i] = number[length-1-i];
//             number[length-1-i] = temp;
//         }

//         for (int i=0;i<number.length; i++) {
//             result += number[i];
//         }

//         return result;
//     }
// }

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }

        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int count = Math.min(countX[i], countY[i]);

            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }

        if (sb.length() == 0) {
            return "-1";
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}