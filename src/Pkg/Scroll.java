package Pkg;
public class Scroll {
    Node head = null;
    Node cur = null;

    public Scroll() {
        
    }

    public void add(Node n) {
        if (head == null) {
            head = n;
            cur = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    public void add(String s, Boolean isFunction) {
        Node n = new Node(s, isFunction);
        add(n);
    }

    public void add(String s) {
        Node n = new Node(s);
        add(n);
    }

    public void next() {
        if (cur != null && cur.next != null) {
            cur = cur.next;
        }
    }

    public void prev() {
        if (cur != null && cur.prev != null) {
            cur = cur.prev;
        }
    }
}
