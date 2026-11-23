package ihablab4;

public class linkedlist {
    Node head;
    String name;

    linkedlist() {
        this("Linked List");
    }

    linkedlist(String name) {
        this.name = name;
        head = null;
    }

    linkedlist(Node h) {
        this("Linked List");
        head = h;
    }

    boolean isempty() {
        return head == null;
    }

    void insertatfront(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    void insertatback(int d) {
        Node n = new Node(d);
        if (isempty()) {
            head = n;
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = n;
    }

    void insertafter(int element, int targetElement) {
        Node current = head;
        while (current != null && current.data != targetElement) current = current.next;
        if (current == null) return;
        Node n = new Node(element);
        n.next = current.next;
        current.next = n;
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void deletefromfront() {
        if (!isempty()) head = head.next;
    }

    void deletefromback() {
        if (isempty()) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) current = current.next;
        current.next = null;
    }

    // Positions start at 1, so position 1 removes the first node.
    void deleteatposition(int pos) {
        if (pos < 1 || isempty()) return;
        if (pos == 1) {
            deletefromfront();
            return;
        }
        Node current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) current = current.next;
        if (current != null && current.next != null) current.next = current.next.next;
    }

    int occurenceNB(int a) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data == a) count++;
            current = current.next;
        }
        return count;
    }

    int evenNBs() {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) count++;
            current = current.next;
        }
        return count;
    }

    int maximum() {
        if (isempty()) return -1;
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) max = current.data;
            current = current.next;
        }
        return max;
    }

    boolean issorted() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data > current.next.data) return false;
            current = current.next;
        }
        return true;
    }

    double average() {
        int count = 0;
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            count++;
            current = current.next;
        }
        if (count == 0) return 0;
        return (double) sum / count;
    }
}
