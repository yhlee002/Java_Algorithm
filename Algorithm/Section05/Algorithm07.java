package Algorithm.Section05;

import java.util.Scanner;

/*
    교육과정 설계
    첫 줄에 필수과목이 순서대로 입력
    다음 줄에 설계한 수업설계가 입력
    필수과목은 연속되지는 않아도 되지만 순서는 반드시 지켜져야 함
    (ex. "CBA"일 경우, "CBDEA"는 설계가 잘된 것, "CADEB"는 틀린 것)
    해당 수업설계가 잘된 것이면 "YES", 틀린 것이면 "NO"
 */
public class Algorithm07 {
    private String solution(String mandatories, String subjects) {
        char[] manQueue = mandatories.toCharArray();
        char[] subQueue = subjects.toCharArray();

        int manFront = 0;
        int subFront = 0;
        while (subFront < subjects.length() && manFront < mandatories.length()) {
            if (subQueue[subFront] == manQueue[manFront]) {
                manFront++;
            }
            subFront++;
        }

        if (manFront == manQueue.length) return "YES"; // manQueue가 다 비워졌는지(size == 0) 확인
        else return "NO";
    }

    public static void main(String[] args) {
        Algorithm07 al = new Algorithm07();
        Scanner sc = new Scanner(System.in);

        String mandatories = sc.nextLine();
        String subjects = sc.nextLine();
        System.out.println(al.solution(mandatories, subjects));
    }
}
