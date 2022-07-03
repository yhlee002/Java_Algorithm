package Algorithm.Section03;

import java.util.*;

/*
    오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력
    첫 번째 줄에 첫 번째 배열의 크기 N 입력
    두 번째 줄에 N개의 배열 원소가 오름차순으로 입력
    세 번째 줄에 두 번째 배열의 크기 M 입력
    네 번째 줄에 M개의 배열 원소가 오름차순으로 입력
    cf. 각 리스트의 원소는 int형 변수의 크기를 넘지 않음
 */
public class Algorithm01 {
    private List<Integer> solution(List<Integer> list1, List<Integer> list2) {
        List<Integer> answer = new ArrayList<>();
        answer.addAll(list1);
        answer.addAll(list2);
        Collections.sort(answer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : o1 < o2 ? -1 : 0;
            }
        });

        return answer;
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list2.add(sc.nextInt());
        }

        List<Integer> result = al.solution(list1, list2);
        for (int i = 0; i < n + m; i++) System.out.printf("%d ", result.get(i));
    }
}
