/*
Programmers Level 2
공원
[PCCE 기출문제] 10번 문제
 */

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        int matSize = 0;
        for (int i=0 ;i<mats.length; i++) {
            matSize = mats[i];
            if (searchPark(matSize, park) && answer < mats[i])
                answer = mats[i];
        }

        return answer;
    }

    public boolean searchPark(int matSize, String[][] park) {

        for (int i=0; i<park.length;i++) {
            for (int k=0; k<park[i].length;k++) {

                if (i+matSize > park.length)
                    continue;
                if (k+matSize > park[i].length)
                    continue;

                if (canPlace(i, k, matSize, park)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPlace(int row, int col, int matSize, String[][] park) {
        for (int i=0;i<matSize;i++) {
            for (int k=0;k<matSize;k++) {
                if (!(park[row+i][col+k].equals("-1")))
                    return false;
            }
        }
        return true;
    }
}