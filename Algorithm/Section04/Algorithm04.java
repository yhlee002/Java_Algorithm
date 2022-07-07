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
        int answer = 0, idx = 0, lt = 0, len = t.length();

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sTempMap = new HashMap<>();

        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        for (int i = 0; i < len - 1; i++) // 길이보다 하나 작게
            sTempMap.put(s.charAt(idx), sTempMap.getOrDefault(s.charAt(idx++), 0) + 1);

        for (int rt = idx; rt < s.length(); rt++) {
            sTempMap.put(s.charAt(rt), sTempMap.getOrDefault(s.charAt(rt), 0) + 1);
            if (tMap.equals(sTempMap)) answer++;
            sTempMap.put(s.charAt(lt), sTempMap.get(s.charAt(lt)) - 1);
            if (sTempMap.get(s.charAt(lt)) == 0) sTempMap.remove(s.charAt(lt));
            lt++;
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
