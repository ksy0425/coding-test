/**
 * 문제
 * 파스칼 고등학교에 다니는 많은 여학생들은 규정에 없는 귀걸이를 착용한 채 도망다닙니다. Sneddon 교감선생님은 흔들거리는 긴 빨간 귀걸이들을 볼때마다 압수합니다.
 * 교감선생님은 귀걸이를 압수당한 여학생들을 숫자를 매겨 리스트를 작성하고 있습니다. 그리고 압수한 귀걸이 뒤쪽에 여학생 번호와 마음대로 선택한 'A' 또는 'B'를 함께 적어두었습니다.
 * 모든 정규 일과와 방과후 수업의 감금이 끝나면, 여학생들은 교감선생님을 찾아와 귀걸이를 돌려받습니다. 불행하게도 어느 날, 교감선생님은 귀걸이가 든 봉투를 잃어버렸고, 하나를 끝내 찾지 못했습니다.
 * 귀걸이를 받지 못해 화난 소녀의 이름을 교감선생님께 알려주세요.
 *
 * 입력
 * 입력은 번호를 가진 시나리오들로 구성됩니다. 시나리오 번호는 1부터 순서대로 증가하고, 각 시나리오는 아래의 내용을 포함합니다.
 * 한 줄에 귀걸이를 압수당한 여학생의 수, n (1 ≤ n ≤ 100)이 주어집니다.
 * 다음 n줄에 걸쳐 여학생들의 이름(최대 60자)이 주어집니다.
 * 다음 2n − 1줄에 여학생 번호와 'A' 또는 'B'가 공백을 사이에 두고 주어집니다. 번호는 교감선생님의 여학생 이름 리스트와 순서가 일치합니다. 즉, 1은 첫 번째로 압수당한 여학생입니다. 여학생 번호는 최대 2번 등장하며, 두 번째로 등장할 때는 첫 번째 경우와 다른 'A' 또는 'B'가 뒤에 적힙니다.
 * 번호가 처음 등장하는 것은 압수되었음을, 두 번째로 등장하는 것은 돌려받았음을 의미합니다.
 * '0'을 마지막 줄로 하여 입력이 종료됩니다. '0'은 처리하지 않습니다.
 *
 * 출력
 * 시나리오 번호와 귀걸이를 돌려받지 못한 여학생의 이름을 공백으로 구분하여 한 줄씩 출력하십시오.
 *
 * 메모리 16088KB
 * 시간 120ms
 */

import java.io.*;
import java.util.*;

public class BOJ_1380 {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int studentNum;
    private String[] studentName;
    private int scenarioCount = 0;

    public void inputStudentNum() throws IOException {
        studentNum = Integer.parseInt(br.readLine());
        studentName = new String[studentNum];
    }

    public boolean isGoScenario() {
        if ( studentNum == 0)
            return false;
        return true;
    }

    public void inputStudentName() throws IOException {
        for (int i = 0; i< studentNum; i++) {
            studentName[i] = br.readLine();
        }
    }

    public void startScenario() throws IOException {
        scenarioCount++;
        String[] lostOrFindLine = new String[2*studentNum-1];
        int[] lostOrFindInteger = new int[2*studentNum-1];
        for (int i=0; i < 2*studentNum-1; i++) {
            String[] studentIndex = br.readLine().split(" "); // 1 A
            lostOrFindLine[i] = studentIndex[0]; //번호만 있으면 될 듯
            lostOrFindInteger[i] = Integer.parseInt(lostOrFindLine[i]) - 1; // 0 1 2
        } // lostOrFindInteger[0~4] = 0 1 2 2 1
        int lostStudentIndex = lostedStudent(lostOrFindInteger); // lostStudentIndex = 1
        String lostStudentName = studentName[lostStudentIndex]; // A
        printStudentName(scenarioCount, lostStudentName);
    }

    public int lostedStudent(int[] lostOrFindInteger) { // lostOrFindInteger[0~4] = 0 1 2 2 1
        int[] findedStudent = new int[studentNum]; // 사이즈 3짜리
        for (int i =0; i<lostOrFindInteger.length;i++) { // 라인 수 반복
            int compareNum = lostOrFindInteger[i]; // 2
            for (int k=i+1; k< lostOrFindInteger.length; k++) {

                if (compareNum == lostOrFindInteger[k]) { // 2 == 2
                    findedStudent[lostOrFindInteger[i]] = 1; //findedStudent[0] = 1, 1이 찾았다는거, findedStudent[2] = 1
                    break;
                }

            }

        }
        for (int i=0;i< findedStudent.length; i++) {
            if(findedStudent[i]==0)
                return i;
        }
        return -1;
    }

    public void printStudentName(int scenarioCount, String stdentName) {
        System.out.println(scenarioCount + " " + stdentName);
    }

    public static void main(String[] args) throws IOException {
        BOJ_1380 boj1380 = new BOJ_1380();

        for (;;) {
            boj1380.inputStudentNum();
            if (!boj1380.isGoScenario())
                break;
            boj1380.inputStudentName();
            boj1380.startScenario();
        }
    }
}