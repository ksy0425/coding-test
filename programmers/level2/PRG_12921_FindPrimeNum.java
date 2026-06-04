/*
Programmers Level 2
소수 찾기
에라토스테네스의 체 알고리즘 이용 문제
 */

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isComposite = new boolean[n+1];

        for (int i=2; i*i <= n; i++) {
            if (!isComposite[i]) {
                for (int k=i*i; k<=n;k += i)
                    isComposite[k] = true;
            }
        }

        for (int i=2;i<=n;i++) {
            if (!isComposite[i])
                answer++;
        }

        return answer;
    }
}