/*
Programmers Level 2
폰켓몬
해시 문제
*/

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int numsLength = nums.length;
        boolean[] numsType = new boolean[200001];

        for (int i=0;i<numsLength;i++) {
            if (!numsType[nums[i]])
                numsType[nums[i]] = true;
        }
        for (int i=0;i<numsType.length;i++) {
            if (answer < numsLength/2) {
                if (numsType[i])
                    answer++;
            }
        }

        return answer;
    }
}