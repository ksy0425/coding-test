/*
Programmers Level 1
배열 만들기2
배열 조작 및 dfs시용 문제
 */

import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] temp = new int[100000];
        int[] count = new int[1];

        dfs("5", l, r, temp, count);

        if (count[0] == 0) {
            return new int[]{-1};
        }

        int[] result = Arrays.copyOf(temp, count[0]);
        Arrays.sort(result);
        return result;
    }

    private void dfs(String cur, int l, int r, int[] temp, int[] count) {
        int num = Integer.parseInt(cur);
        if (num > r) return;

        if (num >= l && num <= r) {
            temp[count[0]++] = num;
        }

        dfs(cur + "0", l, r, temp, count);
        dfs(cur + "5", l, r, temp, count);
    }
}
