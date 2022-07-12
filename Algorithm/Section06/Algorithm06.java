package Algorithm.Section06;

import java.util.Scanner;

/*
    장난꾸러기
    선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세움
    제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여
    철수는 짝꿍보다 키가 크지만 앞 번호를 받고 싶어 짝꿍과 자리를 바꿈
    선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여
    철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때,
    철수가 받은 번호와 철수 짝꿍이 받은 번호를 차례로 출력

    첫 줄에 자연수 N(5<=N<=100)이 입력
    다음 줄에 제일 앞에부터 일렬로 서있는 학생들의 키(120<=H<=180, 자연수) 입력
*/
public class Algorithm06 {
    private int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i - 1;
            if (arr[j] > tmp) {
                while (arr[j] > tmp) arr[j + 1] = arr[j--];
                answer[0] = j + 2; // 인덱스 : j + 1
                answer[1] = i + 1; // 인덱스 : i
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm06 al = new Algorithm06();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int x : al.solution(n, arr)) System.out.print(x + " ");
    }
}
