package Algorithm.Section07;

// 이진트리순회(깊이우선탐색)
class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Algorithm05 { // 자체로 Tree 클래스라 가정
    Node root;

    public void dfs(Node root) {
        if (root != null) {
            dfs(root.lt);
            System.out.print(root.data + " ");
            dfs(root.rt);
        }
    }

    public static void main(String[] args) {
        Algorithm05 tree = new Algorithm05();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }

}
