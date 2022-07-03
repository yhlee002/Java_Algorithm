package Algorithm.Section02;

import java.util.Scanner;

/*
    멘토링
    학생 간의 멘토와 멘티 지정. 멘토는 M번의 테스트에서 항상 멘티보다 점수가 높아야 함
    첫 줄에 반 학생 수 N와 테스트 횟수 M 입력
    다음 줄 부터는 M개의 줄에 걸쳐 테스트 결과의 등수순으로 학생번호 입력
    짝을 만들 수 있는 경우의 수 출력
*/
public class Algorithm12 {
    private int solution(int students, int tests, int[][] grid) {
        int answer = 0;

        // 첫번째 시험을 기준으로 하면 됨. grid[0][i]의 요소들을 순서대로 항상 자신이 뒷 요소보다 앞에 있는지 확인하면 됨
        for (int i = 0; i < students; i++) {
            int stdNum = grid[0][i];
            boolean[] checked = new boolean[students + 1]; // 각 학생들에 아직 앞서는지 확인이 다 안된 상태라면 false, 이미 한 번이라도 뒤쳐진 상황이면 true
            for (int k = i; k < students; k++) {
                if(i != k && !checked[grid[0][k]]) { // k = i + 1로 할 경우 발생될 수 있는 Index Out of Bound Exception 방지
                    int mentee = grid[0][k];
                    int idx1 = 0;
                    int idx2 = 0;
                    for(int j = 1; j < tests; j++) {
                        for (int l = 0; l < students; l++) {
                            if (stdNum == grid[j][l]) idx1 = l;
                            else if (mentee == grid[j][l]) idx2 = l;
                        }
                        if (idx1 >= idx2) {
                            checked[grid[0][k]] = true; // 해당 학생 번호에 체크
                            break;
                        }
                    }
                    if (!checked[grid[0][k]]) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm12 al = new Algorithm12();
        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();
        int tests = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[tests][students];
        for (int i = 0; i < tests; i++) {
            for (int j = 0; j < students; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(al.solution(students, tests, grid));
    }
}
