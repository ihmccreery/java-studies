class LinkedList {
    private Node head;

    public LinkedList() {
    }

    public void insert(int a) {
        this.head = new Node(a, this.head);
    }

    public boolean lookup(int a) {
        if (this.head == null) {
            return false;
        } else {
            return this.head.lookup(a);
        }
    }

    public int length() {
        if (this.head == null) {
            return 0;
        } else {
            return this.head.length();
        }
    }

    private class Node {
        int data;
        Node next;

        Node(int a, Node next) {
            this.data = a;
            this.next = next;
        }

        boolean lookup(int a) {
            if (this.data == a) {
                return true;
            } else if (this.next == null) {
                return false;
            } else {
                return this.next.lookup(a);
            }
        }

        int length() {
            if (this.next == null) {
                return 1;
            } else {
                return 1 + this.next.length();
            }
        }
    }
}
