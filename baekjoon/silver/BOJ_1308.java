/*
 * 문제
 * 캠프에 오게 된 송유진은 캠프가 너무 지루해서 오늘로부터 캠프가 끝날 때 까지 며칠이나 남았는지 알아보고 싶었다.
 * 그런데 캠프는 비상식적으로 길지도 몰라서 (윤년을 포함할지도 모른다) 손으로 하나하나 세기에는 힘들어 보였다.
 * 더욱 정확한 계산을 위해, 유진이는 윤년이 정해지는 기준을 찾아보았고, 그것은 다음과 같았다.
 * 서력기원 연수가 4로 나누어떨어지는 해는 우선 윤년으로 한다. (2004년, 2008년, …)
 * 100으로 나누어떨어지는 해는 평년으로 한다. (2100년, 2200년, …)
 * 400으로 나누어떨어지는 해는 다시 윤년으로 한다. (1600년, 2000년, …)
 * 그런데 캠프가 너무 길 경우, 사춘기인 유진이는 캠프에 무단으로 빠질지도 모른다.
 *
 * 입력
 * 첫째 줄에 오늘의 날짜가 주어지고, 두 번째 줄에 D-Day인 날의 날짜가 주어진다. 날짜는 연도, 월, 일순으로 주어지며, 공백으로 구분한다.
 * 입력 범위는 1년 1월 1일부터 9999년 12월 31일 까지 이다. 오늘의 날짜는 항상 D-Day보다 앞에 있다.
 *
 * 출력
 * 오늘부터 D-Day까지 x일이 남았다면, "D-"를 출력하고 그 뒤에 공백 없이 x를 출력한다.
 * 만약 캠프가 천년 이상 지속된다면 (오늘이 y년 m월 d일이고, D-Day가 y+1000년 m월 d일과 같거나 늦다면) 대신 "gg"를 출력한다. 오늘이 2월 29일인 경우는 주어지지 않는다.
 *
 * 메모리 15836KB
 * 시간 124ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1308 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int[] today = new int[3];
    private int[] dDay = new int[3];
    private int remainingDay = 0;

    private void inputToday() throws IOException {
        String text = br.readLine();
        String[] day = text.split(" ");
        for (int i=0;i<day.length; i++) {
            today[i] = Integer.parseInt(day[i]);
        }
    }

    private void inputDday() throws IOException {
        String text = br.readLine();
        String[] day = text.split(" ");
        for (int i=0;i<day.length; i++) {
            dDay[i] = Integer.parseInt(day[i]);
        }
    }

    public boolean gg() {
        if (dDay[0] > today[0] + 1000)
            return true;
        else if (dDay[0] == today[0] + 1000) {
            if (dDay[1] > today[1] || (dDay[1] == today[1] && dDay[2] >= today[2]))
                return true;
        }
        return false;
    }

    private void findDday() {
        if (gg())
            System.out.println("gg");

        else { // 1000년 남은거 아니니까 로직 계산 여기서 해보자

            int day=0;
            boolean flag = true;
            while (flag)  { // 같아질 때까지 돌리기
                if (today[0] == dDay[0] && today[1] == dDay[1]) {
                    day = dDay[2] - today[2];
                    remainingDay += day;
                    break;
                }
                else {
                    switch (today[1]) {
                        case 1: day = 31 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 2: day = calcLeapYear() - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 3: day = 31 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 4: day = 30 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 5: day = 31 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 6: day = 30 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 7: day = 31 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 8: day = 31 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 9: day = 30 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 10: day = 31 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 11: day = 30 - today[2]+1; remainingDay += day; today[1]++; today[2] = 1; break;
                        case 12: day = 31 - today[2]+1; remainingDay += day; today[0]++; today[1] = 1; today[2] = 1; break;
                    }
                }

            }
            System.out.println("D-"+remainingDay);
        }

    }

    public int calcLeapYear() {
        if (today[0] % 4 ==0) { // 윤년
            if (today[0] % 100 == 0) { //평년
                if (today[0] % 400 == 0) //윤년
                    return 29;
                else
                    return 28;
            }
            else
                return 29;
        }
        else // 평년
            return 28;
    }

    public static void main(String[] args) throws IOException {
        BOJ_1308 boj1308 = new BOJ_1308();
        boj1308.inputToday();
        boj1308.inputDday();
        boj1308.findDday();
    }
}