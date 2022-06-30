package Algorithm.Section02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
     가위바위보
     첫 번째 줄에 게임 횟수인 자연수 N 입력
     두 번째, 세 번째 줄에는 A와 B가 낸 가위, 바위, 보 정보가 N개 입력
     각 줄에 각 회의 승자를 출력(비긴 경우 D 출력)
 */
public class Algorithm03 {
    private List<String> solution(int num, List<Integer> aList, List<Integer> bList) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (aList.get(i) < bList.get(i)) {
                if (aList.get(i) == 1 && bList.get(i) == 3) answer.add("A");
                else answer.add("B");
            } else if (aList.get(i) > bList.get(i)) {
                if (aList.get(i) == 3 && bList.get(i) == 1)
                    answer.add("B");
                else answer.add("A");
            } else {
                answer.add("D");
            }
        }

        return answer;
    }
    public static void main(String args[]) {
        Algorithm03 al = new Algorithm03();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            aList.add(sc.nextInt());
        }

        for (int i = 0; i < cnt; i++) {
            bList.add(sc.nextInt());
        }

        List<String> result = al.solution(cnt, aList, bList);
        for(int i = 0; i < cnt; i++) {
            System.out.println(result.get(i));
        }
    }
}
