package Algorithm.Section04;

import java.util.*;

/*
    1부터 100사이의 자연수가 적힌 N장의 카드 존재. 같은 숫자의 카드가 여러장 있을 수 있음
    이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록(모든 경우를 기록)
    기록한 값 중 K번째로 큰 수를 출력
    첫 줄에 N, K 입력
    다음 줄에 N개의 카드값 입력
 */
public class Algorithm05 {
    private int solution(int n, int k, Integer[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;

        // reverse array
        Arrays.sort(arr);

        List<Integer> reverseLst = Arrays.asList(arr);
        Collections.reverse(reverseLst);

        for (int i = 0; i < n; i++) {
            int sum = 0;
            boolean[] chk1 = new boolean[n];

            for (int j = 0; j < n; j++) {
                if (j == i || chk1[j]) continue;

                boolean[] chk2 = new boolean[n];
                for (int l = 0; l < n; l++) {
                    if (l == i || l == j || chk2[l]) continue;
                    sum = reverseLst.get(i) + reverseLst.get(j) + reverseLst.get(l);
                    map.put(sum, map.getOrDefault(sum, 0) + 1) ;

                    chk2[l] = true;
                }
                chk1[j] = true;
            }
        }

        // map(sum) -> list or array, sort desc
        int[] list = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(list);
        if (list.length - k > 0) return list[list.length - k];
        else return -1;
    }

    public static void main(String[] args) {
        Algorithm05 al = new Algorithm05();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(al.solution(n, k, arr));
    }
}
