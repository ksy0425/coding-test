/*
Programmers Level 2
동영상 재생기
[PCCP 기출문제] 1번 문제
 */

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        // 모든 시간을 초 단위로 변환
        int curPos = toSecond(pos);
        int comOpStart = toSecond(op_start);
        int comOpEnd = toSecond(op_end);
        int comVideoLen = toSecond(video_len);

        for (int i = 0; i < commands.length; i++) {

            if (comOpStart <= curPos && curPos <= comOpEnd) {
                curPos = comOpEnd;
            }

            if (curPos <= 10 && commands[i].equals("prev")) {
                curPos = 0;
                continue;
            }

            if (curPos >= comVideoLen - 10 && commands[i].equals("next")) {
                curPos = comVideoLen;
                continue;
            }

            switch (commands[i]) {
                case "prev":
                    curPos -= 10;
                    break;

                case "next":
                    curPos += 10;
                    break;
            }
        }
        // 마지막 명령 후 오프닝 부분 한번 더 검사
        if (comOpStart <= curPos && curPos <= comOpEnd) {
            curPos = comOpEnd;
        }

        return toTime(curPos);
    }

    // 초 단위로
    public int toSecond(String time) {
        String[] split = time.split(":");

        int minute = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[1]);

        return minute * 60 + second;
    }

    // 시간 형식 다시 맞추기
    public String toTime(int time) {
        int minute = time / 60;
        int second = time % 60;

        return String.format("%02d:%02d", minute, second);
    }
}