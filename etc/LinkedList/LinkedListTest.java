package etc.LinkedList;

class LinkedList {
    Node header;
    // 데이터 저장 용도가 아닌 대표격으로만 사용

    static class Node {
        int data;
        Node next = null;
    }

    public LinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) n = n.next;
        n.next = end;
    }

    void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) n.next = n.next.next;
            else n = n.next;
        }
    }

    void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        } // 마지막 노드는 출력하지 않음
        System.out.println(n.data);
    }
}

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(2);
        ll.retrieve();
    }
}
