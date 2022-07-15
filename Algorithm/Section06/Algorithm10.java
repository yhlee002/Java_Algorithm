package Algorithm.Section06;

import java.util.Arrays;
import java.util.Scanner;

/*
    마구간 정하기
    N개의 마구간이 수직선상에 있음. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없음
    현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않음
    각 마구간에는 한 마리의 말만 넣을 수 있고, 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하려고 함
    C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력
    첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N) 입력
    다음 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000) 입력
 */
public class Algorithm10 {
    private int solution(int n, int c, int[] list) {
        int answer = Integer.MIN_VALUE;

        // 좌표가 아닌 좌표간의 거리가 문제의 답임을 명심해야 함
       int[] clone = list.clone();
        Arrays.sort(clone);
        int lt = clone[1] - clone[0]; // 첫 좌표 값으로 하면 마구간 사이의 간격이 안나올 수 있음(첫번째 값이 간격값보다 클 수 있기 때문)
        int rt = clone[n - 1] - clone[0];

        // mid는 임의로 정한 이전에 배치한 말과의 거리이며, 이 거리보다 좁은 간격일 때에는 cnt 배치 X. 배치될 때마다 마지막 말 위치 지정(ep: end point)
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1, ep = clone[0];
            for (int i = 1; i < n; i++) { // 두 번째 마굿간부터 루프 시작
                if (clone[i] - ep >= mid) { // distance between two point is bigger than mid
                    cnt++;
                    ep = clone[i];
                }
            }

            if (cnt >= c) {
                lt = mid + 1;
                if (answer < mid) answer = mid;
            } else rt = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm10 al = new Algorithm10();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 마구간의 수
        int c = sc.nextInt(); // 말의 수
        int[] list = new int[n]; // 마굿간들의 좌표
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();

        System.out.println(al.solution(n, c, list));
    }
}
