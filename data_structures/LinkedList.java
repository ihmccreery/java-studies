class LinkedList {
    private Node head;
    private int numEntries;

    public LinkedList() {
        this.numEntries = 0;
    }

    public void insert(int a) {
        this.head = new Node(a, this.head);
        this.numEntries++;
    }

    public boolean lookup(int a) {
        if (this.head == null) {
            return false;
        } else {
            return this.head.lookup(a);
        }
    }

    public int[] values() {
        if (this.head == null) {
            return new int[0];
        } else {
            int[] values = new int[this.numEntries];
            Node currentNode = this.head;
            for(int i = 0; i < numEntries; i++) {
                values[i] = currentNode.data;
                currentNode = currentNode.next;
            }
            return values;
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
    }
}
