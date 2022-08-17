package Algorithm.Section09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 회의실 배정
public class Algorithm02 {
    static int n;
    static Item[] list;
    static int max;

    static class Item {
        int start;
        int end;

        public Item(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    void solution() {
        max = 0;
        for (int i = 0; i < list.length; i++) {
            traversal(i, 1);
        }

        System.out.println(max);
    }

    void traversal(int idx, int cnt) {
        boolean flag = true;
        Item item = list[idx];
        for (int i = idx + 1; i < n; i++) {
            if (item.end <= list[i].start) {
                flag = false;
                traversal(i, cnt + 1);
                break;
            }
        }
        if (flag) {
            max = Math.max(max, cnt);
            return;
        }
    }

    public static void main(String[] args) {
        Algorithm02 main = new Algorithm02();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new Item[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list[i] = new Item(s, e);
        }
        Arrays.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.start > o2.start ? 1 : o1.start == o2.start ? 0 : -1;
            }
        });

        main.solution();
    }
}
