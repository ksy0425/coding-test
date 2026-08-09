/*
Programmers Level 2
가장 많이 받은 선물
2024 KAKAO WINTER INTERNSHIP 문제
 */

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[][] graph = new int[friends.length][friends.length];
        for (int i=0;i<gifts.length; i++) {
            String[] history = gifts[i].split(" ");
            for (int k=0;k<friends.length;k++) {

                if (friends[k].equals(history[0])) {
                    for (int j=0;j<friends.length;j++) {
                        if (friends[j].equals(history[1])) {
                            graph[k][j]++;
                        }
                    }
                }
            }
        }

        // 선물 지수 표 함수 호출
        int[][] giftCount = getGraphGiftCount(graph);

        int[] count = new int[friends.length];
        for (int i=0;i<graph.length;i++) {
            for (int k = i + 1;k<graph[i].length; k++) {

                if (graph[i][k] > graph[k][i])
                    count[i]++;
                else if (graph[i][k] < graph[k][i])
                    count[k]++;
                else {
                    // 선물 지수 비교
                    if (giftCount[i][2] > giftCount[k][2])
                        count[i]++;
                    else if (giftCount[i][2] < giftCount[k][2])
                        count[k]++;
                }

            }
        }

        printGraph(graph);
        answer = getMax(count);
        return answer;
    }

    public int getMax(int[] count) {
        int max = count[0];
        for (int i=1 ; i<count.length; i++) {
            if (max <= count[i])
                max = count[i];
        }
        return max;
    }

    public int[][] getGraphGiftCount(int[][] graph) {
        int[][] giftGraph = new int[graph.length][3];
        for (int i=0;i<graph.length; i++) {
            for (int k =0;k<graph[i].length;k++) {
                if (i != k) {
                    giftGraph[i][0] += graph[i][k]; // 선물 한 것 카운트
                    giftGraph[k][1] += graph[i][k]; // 받은 것 카운트
                }
            }
        }

        for (int i=0; i<giftGraph.length;i++) {
            giftGraph[i][2] = giftGraph[i][0] - giftGraph[i][1];
        } // 선물 지수도 구함

        return giftGraph;
    }

    public void printGraph(int[][] graph) {
        for (int i=0;i<graph.length; i++) {
            for (int k=0;k<graph[i].length;k++) {
                System.out.print(graph[i][k] + "  ");
            }
            System.out.println();
        }
    }
}