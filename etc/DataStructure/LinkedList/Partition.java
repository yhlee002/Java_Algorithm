package etc.DataStructure.LinkedList;

// 값으로 나누기
// 특정 값보다 x값이 작거나 같은 노드들을 왼편에 나열, 크거나 같은 노드들을 오른편에 나열
// x값은 어디에 있어도 괜찮음
class LinkedList5 extends LinkedList {
    Node get(int idx) {
        int cnt = 1;
        Node n = header;
        while (n.next != null) {
            n = n.next;
            if (cnt == idx) {
                return n;
            }
        }
        return n;
    }

    Node partition(Node n, int x) {
        Node s1 = null;
        Node s2 = null;
        Node e1 = null;
        Node e2 = null;

        while (n != null) {
            Node next = n.next;
            n.next = null;
            if (n.data < x) {
                if (s1 == null) {
                    s1 = n;
                    e1 = n;
                } else e1.next = n;
                e1 = n;
            } else {
                if (s2 == null) {
                    s2 = n;
                    e2 = n;
                }
                else e2.next = n;
                e2 = n;
            }
            n = next;
        }
        if (s1 != null) {
            e1.next = s2;
            header.next = s1;
            return s1;
        }else return s2;
    }

    Node partition2(Node n, int x) {
        Node head = n;
        Node tail = n;
        while (n != null) {
            Node next = n.next;
            if (n.data < x) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;
        return head;
    }
}

public class Partition {
    public static void main(String[] args) {
        int k = 5;
        LinkedList5 ll = new LinkedList5();
        ll.append(8);
        ll.append(5);
        ll.append(2);
        ll.append(7);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

//        ll.partition(k);
//        LinkedList.Node node = ll.partition(ll.get(1), k);
        LinkedList.Node node = ll.partition2(ll.get(1), k);
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }
}
