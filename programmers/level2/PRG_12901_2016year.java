/*
Programmers Level 2
2016년
요일 계산 문제
*/

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        int days = b;
        for (int i=1; i<a; i++) {
            switch (i) {
                case 1: days += 31; break;
                case 2: days += 29; break;
                case 3: days += 31; break;
                case 4: days += 30; break;
                case 5: days += 31; break;
                case 6: days += 30; break;
                case 7: days += 31; break;
                case 8: days += 31; break;
                case 9: days += 30; break;
                case 10: days += 31; break;
                case 11: days += 30; break;
                case 12: days += 31; break;
            }
        }

        switch (days % 7) {
            case 0: answer = "THU"; break;
            case 1: answer = "FRI"; break;
            case 2: answer = "SAT"; break;
            case 3: answer = "SUN"; break;
            case 4: answer = "MON"; break;
            case 5: answer = "TUE"; break;
            case 6: answer = "WED"; break;
        }

        return answer;
    }
}