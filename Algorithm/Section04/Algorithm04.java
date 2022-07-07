package Algorithm.Section04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    문자열 S에서 문자열 T와 아나그램이 되는 S의 부분문자열의 개수 출력
    첫 줄에 S 입력, 다음 줄에 T 입력
 */
public class Algorithm04 {
    private int solution(String s, String t) {
        int answer = 0, idx = 0, len = t.length();

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sTempMap = new HashMap<>();

        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        for (int i = 0; i < t.length() - 1; i++)
            sTempMap.put(s.charAt(idx), sTempMap.getOrDefault(s.charAt(idx++), 0) + 1);

        for (int i = idx; i < s.length(); i++) {
            sTempMap.put(s.charAt(i), sTempMap.getOrDefault(s.charAt(i), 0) + 1);

            boolean flag = true;
            if (tMap.size() == sTempMap.size()) {
                for (char c : tMap.keySet()) {
                    if (sTempMap.get(c) != tMap.get(c)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }
            }

            sTempMap.put(s.charAt(i - len + 1), sTempMap.get(s.charAt(i - len + 1)) - 1);
            if (sTempMap.get(s.charAt(i - len + 1)) == 0) sTempMap.remove(s.charAt(i - len + 1));
        }
        return answer;
    }

    public static void main(String[] args) {
        Algorithm04 al = new Algorithm04();
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(al.solution(s, t));
    }
}
