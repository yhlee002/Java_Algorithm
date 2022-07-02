package Algorithm.Section02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    OX문제(맞으면 1점 틀리면 0점, 연속해서 맞는 경우 K번 연속되는 만큼 점수를 받음)
    첫 줄에는 문제의 수 입력
    다음 줄에는 정답인 경우(1)와 틀린 경우(0)을 띄어쓰기로 나누어 입력
    총점을 출력
* */
public class Algorithm07 {
    private int solution(int num, List<Integer> list) {
        int answer = 0;
        int prev = 0;
        int cnt = 1;
        for (int i = 0; i < num; i++) {
            if (list.get(i) == prev) cnt++;
            else cnt = 1;
            prev = list.get(i);
            if (list.get(i) == 1) answer += cnt;
        }

        return answer;
    }

    public static void main(String args[]) {
        Algorithm07 al = new Algorithm07();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < cnt; i++) {
            list.add(sc.nextInt());
        }

        int result = al.solution(cnt, list);
        System.out.print(result);
    }
}