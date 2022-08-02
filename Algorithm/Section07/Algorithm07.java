package Algorithm.Section07;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm07 {
    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }
    }
    Node root;
    void bfs() {
        Node root = this.root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int L = 0; // level
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                System.out.print(n.data + " ");
                if (n.lt != null) q.offer(n.lt);
                if (n.rt != null) q.offer(n.rt);
            }
            System.out.println();
            L++;
        }
    }

    public static void main(String[] args) {
        Algorithm07 tree = new Algorithm07();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs();
    }
}
