/*
Programmers Level 2
바탕화면 정리
연습 문제
 */

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int lux= wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;
        for (int i=0;i<wallpaper.length; i++) {
            char[] chars = wallpaper[i].toCharArray();
            for (int k=0;k<chars.length;k++) {
                if (chars[k] == '#') {
                    if (lux > i)
                        lux = i;
                    if (rdx < i + 1)
                        rdx = i + 1;
                    if (luy > k)
                        luy = k;
                    if (rdy < k + 1)
                        rdy = k + 1;
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;

        return answer;
    }
}