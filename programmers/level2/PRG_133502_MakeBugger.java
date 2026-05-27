/*
Programmers Level 2
햄버거 만들기
스택 문제
 */

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        int[] stack = new int[ingredient.length];
        int top = 0;

        for (int x:ingredient) {
            stack[top++] = x;

            if (top>=4 &&
                    stack[top-4] == 1 &&
                    stack[top-3] == 2 &&
                    stack[top-2] == 3 &&
                    stack[top-1] == 1) {
                top-=4;
                answer++;
            }
        }

        return answer;
    }
}