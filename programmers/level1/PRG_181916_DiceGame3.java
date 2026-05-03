/*
Programmers Level 1
주사위 게임3
빈도 배열 접근
 */

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;

        int[] numbers = {a, b, c, d};
        int[] check = new int[6];

        for (int i=0;i<numbers.length;i++) {
            check[numbers[i]-1]++;
        }

        for (int i=0;i<check.length;i++) {
            if (check[i] == 4)
                answer = (i+1)*1111;

            else if (check[i]==3) {
                for (int k=0;k<check.length;k++) {
                    if (check[k]==1)
                        answer = ((10*(i+1)) + (k+1)) * ((10*(i+1)) + (k+1));
                }
            }

            else if (check[i]==2) {
                for (int k=i+1;k<check.length;k++) {
                    if (check[k]==2)
                        answer = (i+1 + k+1) * Math.abs(i-k);
                }
                int temp=1;
                for (int k=0;k<check.length;k++) {
                    if (check[k]==1) {
                        temp *= (k+1);
                        answer = temp;
                    }
                }
            }
        }
        if (answer==0)
            answer = findMin(numbers);

        return answer;
    }

    public int findMin(int[] numbers) {
        int min = numbers[0];
        for (int i=1;i<numbers.length;i++) {
            if (min>numbers[i])
                min = numbers[i];
        }
        return min;
    }
}