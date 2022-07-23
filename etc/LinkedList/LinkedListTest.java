package etc.LinkedList;

class LinkedList {
    Node header;
    static class Node {
        int data;
        Node next;
    }

    public LinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node node = header;
        while (node.next != null) node = node.next;
        node.next = end;
    }

    void delete(int d) {
        Node node = header;
        while (node.next != null) {
            if (node.next.data == d) node.next = node.next.next;
            else node = node.next;
        }
    }

    void retrieve() {
        Node node = header;
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        } // 마지막 노드는 출력하지 않음
        System.out.println(node.data);
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
