/*
Programmers Level 2
신규 아이디 추천
2021 KAKAO BLIND RECRUITMENT 문제
 */

class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        //1단계
        answer = new_id.toLowerCase();
        //2단계
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        //3단계
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        //4단계
        if (answer.startsWith("."))
            answer = answer.substring(1);
        if (answer.endsWith("."))
            answer = answer.substring(0, answer.length()-1);
        //5단계
        if (answer.equals("")) {
            // for (int i=0;i<new_id.length(); i++) {
            //     answer += "a";
            // }
            answer += "a";
        }
        //6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith("."))
                answer = answer.substring(0, answer.length()-1);
        }
        //7단계
        if (answer.length() <= 2) {
            char[] chars = answer.toCharArray();
            while (answer.length() < 3) {
                answer += String.valueOf(chars[chars.length-1]);
            }
        }

        return answer;
    }
}