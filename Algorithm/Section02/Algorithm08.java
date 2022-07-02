package Algorithm.Section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력
    같은 점수가 입력될 경우 높은 등수로 동일 처리(가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명, 그 다음 학생은 4등)
    첫 줄에 N이 입력되고, 다음 줄에 각 학생의 점수 입력
    입력된 순서대로 각 점수의 학생의 등수 출력
 */
public class Algorithm08 {
    private int[] solution(int num, int[] list) {
        int[] answer = new int[num];

        // 전체 loop(num + 1 개수의 배열 생성해 체크 여부 확인)
        // 체크 여부에 따라 체크 안된 것만 inner loop (등수 구하기) -> 같은 값인 요소들의 인덱스를 가진다.
        // 같은 값의 요소들의 인덱스도 모두 같은 등수로 바꿔준다. + 체크 여부 바꿈

        boolean[] result = new boolean[num];

        for (int i = 0; i < num; i++) {
            if (!result[i]) {
                List<Integer> sameScore = new ArrayList<>();

                int rank = 1;
                for (int j = 0; j < num; j++) {
                    if (i != j) {
                        if (list[i] == list[j]) sameScore.add(j);
                        else if (list[i] < list[j]) rank++;
                    }
                }
                sameScore.add(i);
                for (int k = 0; k < sameScore.size(); k++) {
                    result[sameScore.get(k)] = true;
                    answer[sameScore.get(k)] = rank;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm08 al = new Algorithm08();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        int[] list = new int[num];
        for (int i = 0; i < num; i++) list[i] = sc.nextInt();

        int[] result = al.solution(num, list);
        for(int i = 0; i < result.length; i++) System.out.printf("%d ", result[i]);
        System.out.println();
    }
}
