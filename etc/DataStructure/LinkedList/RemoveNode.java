package etc.DataStructure.LinkedList;

// 중간 노드 삭제
class LinkedList4 extends LinkedList {
    Node get(int idx) {
        int cnt = 0;
        Node n = header;
        while (n.next != null) {
            n = n.next;
            cnt++;
            if (cnt == idx) {
                return n;
            }
        }
        return n;
    }
    boolean removeNode(Node node) {
        if (node == null || node.next == null) return false;

        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }
}
public class RemoveNode {
    public static void main(String[] args) {
        LinkedList4 ll = new LinkedList4();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.removeNode(ll.get(2));
        ll.retrieve();
        ll.removeNode(ll.get(1));
        ll.retrieve();
        ll.removeNode(ll.get(2)); // 첫 노드, 마지막 노드는 삭제 불가
        ll.retrieve();
    }
}
