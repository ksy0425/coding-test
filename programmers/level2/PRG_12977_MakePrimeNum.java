/*
Programmers Level 2
소수 만들기
소수 판별 및 조합 문제
 */

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int target = 0;
        for (int i=0; i<nums.length;i++) {
            for (int j=i+1; j<nums.length;j++) {
                for (int k=j+1; k<nums.length; k++) {
                    target = 0;
                    target = nums[i] + nums[j] + nums[k];
                    if (isPrime(target))
                        answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }

        return true;
    }
}