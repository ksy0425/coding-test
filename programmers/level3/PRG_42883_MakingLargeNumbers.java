/*
Programmers Level 3
큰 수 만들기
탐욕법(Greedy) 문제
 */

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : number.toCharArray()) {
            // 스택 top보다 현재 숫자가 크면 pop
            while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 아직 제거할 숫자가 남아 있으면 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
