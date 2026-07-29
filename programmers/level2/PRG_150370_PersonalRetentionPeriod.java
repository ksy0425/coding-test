/*
Programmers Level 2
개인정보 수집 유효기간
2023 KAKAO BLIND RECRUITMENT 문제
 */

import java.util.ArrayList;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<privacies.length;i++) {
            if (checkPeriod(today, terms, privacies[i])) {
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i=0;i<answer.length;i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public boolean checkPeriod(String today, String[] terms, String privacies) {
        String[] prParts = privacies.split("[\\. ]");

        int nTerm = 0;
        for (int i=0;i<terms.length;i++) {
            if (terms[i].contains(prParts[3])) {
                String num = terms[i].substring(terms[i].indexOf(" ") + 1);
                nTerm = Integer.parseInt(num);
            }
        }

        int[] nPrParts = new int[3];
        for (int i=0;i<prParts.length-1; i++) {
            nPrParts[i] = Integer.parseInt(prParts[i]);
        }

        if (nPrParts[1] + nTerm > 12) {
            nPrParts[0] += (nPrParts[1] + nTerm - 1) / 12;
            nPrParts[1] = (nPrParts[1] + nTerm - 1) % 12 + 1;
            nPrParts[2]--;
            if (nPrParts[2] == 0) {
                nPrParts[2] = 28;
                nPrParts[1]--;
                if (nPrParts[1] < 1) {
                    nPrParts[0]--;
                    nPrParts[1] = 12;
                }
            }
        }

        else {
            nPrParts[1] += nTerm;
            nPrParts[2] --;
            if (nPrParts[2] == 0) {
                nPrParts[2] = 28;
                nPrParts[1]--;
                if (nPrParts[1] < 1) {
                    nPrParts[0]--;
                    nPrParts[1] = 12;
                }
            }
        }

        String[] todayParts = today.split("\\.");
        int[] nToday = new int[todayParts.length];
        for (int i =0;i<nToday.length; i++) {
            nToday[i] = Integer.parseInt(todayParts[i]);
        }
        if (nToday[0] > nPrParts[0])
            return true;
        else if (nToday[0] == nPrParts[0] && nToday[1] > nPrParts[1])
            return true;
        else if (nToday[0] == nPrParts[0] && nToday[1] == nPrParts[1] && nToday[2] > nPrParts[2])
            return true;

        return false;
    }
}