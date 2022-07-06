package Algorithm.Section04;

import java.util.*;

/*
    학급 회장 선출
    첫 줄에 학생 수 N 입력
    다음 줄에 학생들이 투표한 학생(후보 : A, B, C, D, E)을 순서대로 입력
    선출될 학급 회장 출력
 */
public class Algorithm01 {
    private Character solution(int num, String str) {
        Character answer = null;

        Map<Character, Object> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null) map.put(str.charAt(i), 1);
            else map.put(str.charAt(i), (Integer) map.get(str.charAt(i)) + 1);
        }

        int max = 0;
        Iterator keyIter = map.keySet().iterator();
        while(keyIter.hasNext()) {
            Character key = (Character) keyIter.next();
            int cnt = (int) map.get(key);
            if (max < cnt) {
                max = cnt;
                answer = key;
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
