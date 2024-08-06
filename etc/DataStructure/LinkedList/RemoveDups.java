package etc.DataStructure.LinkedList;
/*
* LinkedList 중복값 제거 문제(별도의 버퍼를 사용하지 않음)
* removeDups만 별도 구현하기 위해 기존 LinkedList 상속
* HashSet을 사용할 경우 시간 복잡도가 O(n)이나, 여기서는 버퍼를 사용하지 않는 것을 전제로 함
* 시간 효율성은 O(n^2)으로 많이 들지만, 공간 효율성은 이미 존재하는 두 개의 포인터만 사용하므로 O(1)
*/
class LinkedList2 extends LinkedList {
    void removeDups() {
        Node n = header;
        while (n != null && n.next != null) { // header 검증은 X
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) r.next = r.next.next;
                else r = r.next;
            }
            n = n.next;
        }
    }
}

public class RemoveDups {
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(2);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}

