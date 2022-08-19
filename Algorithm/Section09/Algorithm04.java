package Algorithm.Section09;

import java.util.*;

// 최대 수입 스케쥴
public class Algorithm04 {

    static class Lecture implements Comparable<Lecture> {
        int m; // money
        int d; // date

        public Lecture(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture l) {
            return l.d - this.d;
        }
    }

    int solution(int max, List<Lecture> list) {
        int sum = 0, j = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = max; i > 0; i--) { // priority queue
            for (; j < list.size(); j++) { // list 순회
                if (list.get(j).d < i) break;
                q.offer(list.get(j).m);
            }
            if (!q.isEmpty()) {
                int tmp = q.poll();
                sum += tmp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Algorithm04 main = new Algorithm04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Lecture(m, d));

            max = Math.max(max, d);
        }

        Collections.sort(list);

        System.out.println(main.solution(max, list));
    }
}
