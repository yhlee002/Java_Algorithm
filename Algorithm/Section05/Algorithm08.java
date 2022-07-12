package Algorithm.Section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    응급실
    의사가 한 명 뿐이기 때문에, 아래와 같은 진료순서를 가짐
    • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냄
    • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣고, 그렇지 않으면 진료를 받음

    N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력
    cf. 대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것
 */
public class Algorithm08 {
    class Person {
        private int no;
        private int priority;

        public void setNo(int no) {
            this.no = no;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getNo() {
            return no;
        }

        public int getPriority() {
            return priority;
        }
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0, cnt = 1;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Person p = new Person();
            p.setNo(i);
            p.setPriority(arr[i]);
            queue.offer(p);
        }

        while (!queue.isEmpty()) {
            Person p = queue.poll();
            boolean flag = true;
            for (Person person : queue) {
                if (p.priority < person.priority) {
                    flag = false;
                    queue.offer(p);
                    break;
                }
            }
            if (flag) {
                if (p.no == m) break;
                else cnt++;
            }
        }

        answer = cnt;

        return answer;
    }

    public static void main(String[] args) {
        Algorithm08 al = new Algorithm08();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(al.solution(n, m, arr));
    }
}
