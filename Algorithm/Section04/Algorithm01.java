package Algorithm.Section04;

import java.util.*;

/*
    학급 회장 선출(해시)
    첫 줄에 학생 수 N 입력
    다음 줄에 학생들이 투표한 학생(후보 : A, B, C, D, E)을 순서대로 입력
    선출될 학급 회장 출력
 */
public class Algorithm01 {
    private char solution(int num, String str) {
        char answer = ' ';

        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int max = Integer.MIN_VALUE;
        for (char c : map.keySet()) {
            int cnt = map.get(c);
            if (max < cnt) {
                max = cnt;
                answer = c;
            }
        }

            return answer;
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String str = sc.next();
        System.out.println(al.solution(num, str));
    }
}
