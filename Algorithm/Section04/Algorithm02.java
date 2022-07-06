package Algorithm.Section04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    입력되는 두 단어 아나그램(문자 배열의 순서만 다를뿐 구성이 같은 단어)인지 판별(해시)
    첫 줄에 문자열 A, 다음 줄에 문자열 B 입력
    아나그램일 경우 "YES", 아닐 경우 "NO" 출력
 */
public class Algorithm02 {
    private String solution(String a, String b) {
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        for (char c : a.toCharArray()) aMap.put(c, aMap.getOrDefault(c, 0) + 1);
        for (char c : b.toCharArray()) bMap.put(c, bMap.getOrDefault(c, 0) + 1);

        for (char c : a.toCharArray()) {
            if (aMap.get(c) != bMap.get(c)) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Algorithm02 al = new Algorithm02();
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(al.solution(a, b));
    }
}
