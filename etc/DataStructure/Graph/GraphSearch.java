package etc.DataStructure.Graph;
/*
    아래의 형태로 트리가 존재할 경우를 가정
      0
     /
    1 - 3    7
    | / | \ /
    2 - 4  5 - 6 - 8

    1) DFS(Depth First Search)
    dfs(0) => 0 1 3 5 7 6 8 4 2
    2) BFS(Breath First Search)
    bfs(0) => 0 1 2 3 4 5 6 7 8
    3) DFS Recursive
    dfsR(0) => 3 1 0 2 4 5 6 8 7
*/

import java.util.*;

class Graph{
    class Node {
        public int data;
        public boolean marked;
        public LinkedList<Node> adjuscent;

        public Node(int data) {
            this.data = data;
            this.marked = false;
            adjuscent = new LinkedList<Node>();
        }

    }

    Node[] nodes;

    public Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) nodes[i] = new Node(i);
    }

    // DFS를 Stack으로 구현
    void dfs() {
        dfs(0);
    }

    void dfs(int idx) {
        Node root = nodes[idx];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node n : node.adjuscent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(node);
        }
    }

    // DFS를 Recursive 방식으로 구현
    void dfsR() {
        dfsR(nodes[0]);
    }

    void dfsR(Node root) {
        root.marked = true;
        visit(root);
        for (Node node : root.adjuscent) {
            if (!node.marked) {
                node.marked = true;
                dfsR(node);
            }
        }
    }

    // BFS를 Queue로 구현
    void bfs() {
        bfs(0);
    }

    void bfs(int idx) {
        Node root = nodes[idx];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node n : node.adjuscent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);

                }
            }
            visit(node);
        }

    }

    void visit(Node node) {
        System.out.print(node.data + " ");
    }


    void addEdge(int e1, int e2) {
        Node n1 = nodes[e1];
        Node n2 = nodes[e2];
        if (!n1.adjuscent.contains(n2)) {
            n1.adjuscent.add(n2);
        }
        if (!n2.adjuscent.contains(n1)) {
            n2.adjuscent.add(n1);
        }
    }
}
public class GraphSearch {
    public static void main(String args[]){
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

//        graph.dfs();
//        graph.bfs();
        graph.dfsR();
    }
}
