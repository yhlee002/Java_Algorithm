package Algorithm.Section09;

import java.util.*;

// 결혼식
public class Algorithm03 {
    static int n;
    static Item[] list;
    static int max = Integer.MIN_VALUE;

    static class Item implements Comparable<Item> {
        int start;
        int end;

        public Item(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Item o) {
            return this.start - o.start;
        }
    }

    void solution() {
        int cnt = 0; // 누가 오고 갈 때마다 카운트를 조정하는 것이 포인트 💫
        for (int k = list[0].start; k < 72; k++) {
            for (int i = 0; i < n; i++) {
                if (list[i].start == k) cnt++; // 해당 시간 정각에 피로연장에 있는 것으로 간주
                else if (list[i].end == k) cnt--; // 해당 시간 정각에 피로연장에 없는 것으로 간주

                max = Math.max(max, cnt);
            }
        }

    }

    public static void main(String[] args) {
        Algorithm03 main = new Algorithm03();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new Item[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list[i] = new Item(start, end);
        }
        Arrays.sort(list);
        main.solution();
        System.out.println(max);
    }
}