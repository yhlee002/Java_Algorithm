package etc.LinkedList;

// 뒤에서 K번째 노드 찾기
import etc.LinkedList.LinkedList.Node;

class LinkedList3 extends LinkedList {
    Node getKthNode(Node first, int idx) {
        int total = 1; // 마지막 노드에는 도달하지 않으므로 1에서 시작
        Node n = header;
        while (n.next != null) {
            total++;
            n = n.next;
        }

        n = header;
        for (int i = 1; i < total - idx + 1; i++) n = n.next;
        return n;
    }

    int getKthNodeRecursive(Node node, int idx) {
        if (node == null) {
            return 0;
        }

        int count = getKthNodeRecursive(node.next, idx) + 1;
        if (count == idx) System.out.println("Last K(" + idx + ")th data is " + node.data);
        return count;
    }

    void getKthNodeWithTwoPointers(Node first, int idx) {
        Node p1 = first;
        Node p2 = first;
        for (int i = 0; i < idx; i++) p1 = p1.next;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("Last K(" + idx + ")th data is " + p2.data);
    }
}
public class KthToLast {
    public static void main(String[] args) {
        int k = 3;
        LinkedList3 ll = new LinkedList3();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        // Non Recursive
        Node kth = ll.getKthNode(ll.header, k);
        System.out.println("Last K(" + k + ")th data is " + kth.data);
        // Recursive
        ll.getKthNodeRecursive(ll.header, k);
        // Two Pointer
        ll.getKthNodeWithTwoPointers(ll.header, k);
    }
}
