package etc.LinkedList;

class LinkedList6 extends LinkedList {
    LinkedList6 getSumDigit(LinkedList ll2) {
        LinkedList6 ll = new LinkedList6();
        Node n = header;
        Node n2 = ll2.header;
        while (n.next != null) {
            ll.append(n.next.data + n2.next.data);
            n = n.next;
            n2 = n2.next;
        }

        return ll;
    }
}

public class SumDigit {
    public static void main(String[] args) {
        int a = 123;
        int b = 456;

        LinkedList6 ll = new LinkedList6();
        LinkedList6 ll2 = new LinkedList6();

        int l = a, k = 10;
        while(l % k / (k / 10) > 0) {
            ll.append(l % k / (k / 10));
            k *= 10;
        }

        l = b; k = 10;
        while(l % k / (k / 10) > 0) {
            ll2.append(l % k / (k / 10));
            k *= 10;
        }

        LinkedList6 newLl = ll.getSumDigit(ll2);
        newLl.retrieve();
    }

}
