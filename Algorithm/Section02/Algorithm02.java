package Algorithm.Section02;

import java.util.*;

/*
    줄 세우기
    N명의 학생을 일렬로 세움. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 학생은 항상 보이고,
    그 이후에는 앞의 학생보다 키가 큰 경우에만 보임. 이 때, 선생님이 볼 수 있는 학생의 수 출력
 */
public class Algorithm02 {
    private int solution(int num, List<Integer> list) {
        int answer = 1; // 첫 번째는 항상 보임
        int max = list.get(0);
        for (int i = 1; i < num; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                answer++;
            }
        }

        return answer;
    }
    public static void main(String args[]) {
        Algorithm02 al = new Algorithm02();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < cnt; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(al.solution(cnt, list));
    }
}
