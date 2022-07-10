package Algorithm.Section05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    공주 구하기
    정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀감
    정보왕국에는 N명의 왕자가 있고, 아래의 방법으로 이 들 중 공주를 구하러 갈 왕자를 결정하기로 함
    왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매기고, 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉힘
    1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치는데, 한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 됨
    그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외침
    마지막까지 남은 왕자가 공주를 구하러 갈 수 있음
    첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9) 입력
 */
public class Algorithm06 {
    private int solution(int n, int k) {
        int answer = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i + 1);

        // 1차 작성 : 링 버퍼를 사용한 큐를 통해 작성
        int idx = 0, listIdx = 0;
        int[] queue = new int[k];
        while (list.size() > 1) {
            if (listIdx >= list.size()) listIdx = 0;
            int num = list.get(listIdx++);

            if (idx >= k) idx = 0; // k와 같아지면 0으로 변경
            queue[idx++] = num;
            if (idx == k) list.remove(--listIdx);
        }
        answer = list.get(0);

        return answer;
    }

    public static void main(String[] args) {
        Algorithm06 al = new Algorithm06();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(al.solution(n, k));
    }
}
