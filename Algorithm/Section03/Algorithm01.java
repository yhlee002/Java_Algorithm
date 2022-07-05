package Algorithm.Section03;

import java.util.*;

/*
    오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력
    첫 번째 줄에 첫 번째 배열의 크기 N 입력
    두 번째 줄에 N개의 배열 원소가 오름차순으로 입력
    세 번째 줄에 두 번째 배열의 크기 M 입력
    네 번째 줄에 M개의 배열 원소가 오름차순으로 입력
    cf. 각 리스트의 원소는 int형 변수의 크기를 넘지 않음
    
    22.07.05 배열의 two point(index)를 이용한 방식으로 수정
    cf. 기존 방식 : List의 addAll() 메서드를 통해 새로운 리스트에 a, b 두 리스트의 원소를 모두 합친 후 오름차순으로 정렬
 */
public class Algorithm01 {
    private List<Integer> solution(int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while(idx1 < a.length && idx2 < b.length) {
            if (a[idx1] < b[idx2]) {
                answer.add(a[idx1]);
                idx1++;

            }
            else if (a[idx1] > b[idx2]) {
                answer.add(b[idx2]);
                idx2++;
            }
            else {
                answer.add(a[idx1]);
                answer.add(b[idx1]);
                idx1++;
                idx2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        List<Integer> result = al.solution(a, b);
        for (int i = 0; i < n + m; i++) System.out.printf("%d ", result.get(i));
    }
}
