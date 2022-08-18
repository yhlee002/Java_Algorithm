package Algorithm.Section09;

import java.util.*;

public class Algorithm02 {
    static int cnt = 0;
    static int n;
    static Item[] list;

    static class Item implements Comparable<Item> {
        int start;
        int end;

        public Item(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Item o) {
            return o.end == this.end ? this.start - o.start : this.end - o.end;
        }
    }

    void solution() {
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (last <= list[i].start) {
                last = list[i].end;
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        Algorithm02 main = new Algorithm02();
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
        System.out.println(cnt);
    }
}