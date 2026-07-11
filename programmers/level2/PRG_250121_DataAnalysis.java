/*
Programmers Level 2
데이터 분석
[PCCE 기출문제] 10번 문제
 */

import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        if (ext.equals("code")) {
            int[] record = new int[data.length];
            int size = 0;
            for (int i=0; i<data.length;i++) {
                if (data[i][0] < val_ext) {
                    record[i] = 1;
                    size++;
                }
                else {
                    record[i] = -1;
                }
            }
            int[][] answer = new int[size][4];
            int idx = 0;
            for (int i=0; i<record.length; i++) {
                if (record[i] != -1) {
                    for (int k=0; k<data[i].length; k++) {
                        answer[idx][k] = data[i][k];
                    }
                    idx++;
                }
            }
            return sortAnswer(answer, sort_by);
        }
        else if (ext.equals("date")) {
            int[] record = new int[data.length];
            int size = 0;
            for (int i=0; i<data.length;i++) {
                if (data[i][1] < val_ext) {
                    record[i] = 1;
                    size++;
                }
                else {
                    record[i] = -1;
                }
            }
            int[][] answer = new int[size][4];
            int idx = 0;
            for (int i=0; i<record.length; i++) {
                if (record[i] != -1) {
                    for (int k=0; k<data[i].length; k++) {
                        answer[idx][k] = data[i][k];
                    }
                    idx++;
                }
            }
            return sortAnswer(answer, sort_by);
        }
        else if (ext.equals("maximum")) {
            int[] record = new int[data.length];
            int size = 0;
            for (int i=0; i<data.length;i++) {
                if (data[i][2] < val_ext) {
                    record[i] = 1;
                    size++;
                }
                else {
                    record[i] = -1;
                }
            }
            int[][] answer = new int[size][4];
            int idx = 0;
            for (int i=0; i<record.length; i++) {
                if (record[i] != -1) {
                    for (int k=0; k<data[i].length; k++) {
                        answer[idx][k] = data[i][k];
                    }
                    idx++;
                }
            }
            return sortAnswer(answer, sort_by);
        }
        else if (ext.equals("remain")) {
            int[] record = new int[data.length];
            int size = 0;
            for (int i=0; i<data.length;i++) {
                if (data[i][3] < val_ext) {
                    record[i] = 1;
                    size++;
                }
                else {
                    record[i] = -1;
                }
            }
            int[][] answer = new int[size][4];
            int idx = 0;
            for (int i=0; i<record.length; i++) {
                if (record[i] != -1) {
                    for (int k=0; k<data[i].length; k++) {
                        answer[idx][k] = data[i][k];
                    }
                    idx++;
                }
            }
            return sortAnswer(answer, sort_by);
        }
        return data;
    }


    public int[][] sortAnswer(int[][] answer, String sort_by) {
        if (sort_by.equals("code")) {
            Arrays.sort(answer, (a, b) -> Integer.compare(a[0], b[0]));
            return answer;
        }
        else if (sort_by.equals("date")) {
            Arrays.sort(answer, (a, b) -> Integer.compare(a[1], b[1]));
            return answer;
        }
        else if (sort_by.equals("maximum")) {
            Arrays.sort(answer, (a, b) -> Integer.compare(a[2], b[2]));
            return answer;
        }
        else if (sort_by.equals("remain")) {
            Arrays.sort(answer, (a, b) -> Integer.compare(a[3], b[3]));
            return answer;
        }
        return answer;
    }
}