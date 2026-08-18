/*
Programmers Level 3
전력망을 둘로 나누기
완전 탐색 문제
 */

import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();
        for (int i=0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            int count = dfs(wire[0], wire[0], wire[1]);
            int other = n - count;
            answer = Math.min(answer, Math.abs(count-other));
        }

        return answer;
    }

    private int dfs(int node, int cutFrom, int cutTo) {
        visited[node] = true;
        int count = 1;

        for (int next : graph.get(node)) {
            if ((node==cutFrom && next==cutTo) || (node==cutTo && next==cutFrom))
                continue;
            if (!visited[next]) {
                count += dfs(next, cutFrom, cutTo);
            }
        }
        return count;
    }
}