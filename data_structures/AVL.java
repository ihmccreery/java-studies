public class AVL<E extends Comparable<E>> {
    Node root;
    Sentinel sentinel;

    public AVL() {
        this.root = this.sentinel = new Sentinel();
    }

    public void insert(E e) {
        this.root = this.root.insert(e);
    }

    public boolean lookup(E e) {
        return this.root.lookup(e);
    }

    private class Node {
        E e;
        Node l;
        Node r;
        int height;

        Node() { }

        Node(E e, Node l, Node r) {
            this.e = e;
            this.l = l;
            this.r = r;
            this.set_height();
        }

        Node insert(E e) {
            if (e.compareTo(this.e) < 0) { // e < this.e
                this.l = this.l.insert(e);
            } else if (e.compareTo(this.e) > 0) { // e > this.e
                this.r = this.r.insert(e);
            } // else e == this.e
            return rebalance();
        }

        private Node rebalance() {
            int balance = this.balance();
            if (balance > 1) { // R
                if (this.r.balance() < 0) { // RL
                    this.r = this.r.rotate_right(); // RL -> RR
                } // RR
                return this.rotate_left();
            } else if (balance < -1) { // L
                if (this.l.balance() > 0) { // LR
                    this.l = this.l.rotate_left(); // LR -> LL
                } // LL
                return this.rotate_right();
            } else {
                this.set_height();
                return this;
            }
        }

        private int balance() {
            return this.r.height - this.l.height;
        }

        private Node rotate_left() {
            Node x = this.r;
            Node y = x.l;
            this.r = y;
            x.l = this;
            this.set_height();
            x.set_height();
            return x;
        }

        private Node rotate_right() {
            Node x = this.l;
            Node y = x.r;
            this.l = y;
            x.r = this;
            this.set_height();
            x.set_height();
            return x;
        }

        private void set_height() {
            this.height = 1 + Math.max(this.l.height, this.r.height);
        }

        boolean lookup(E e) {
            if (e.compareTo(this.e) < 0) { // e < this.e
                return this.l.lookup(e);
            } else if (e.compareTo(this.e) > 0) { // e > this.e
                return this.r.lookup(e);
            } else { // e == this.e
                return true;
            }
        }
    }

    private class Sentinel extends Node {
        Sentinel() {
            this.height = -1;
        }

        Node insert(E e) {
            return new Node(e, this, this);
        }

        boolean lookup(E e) {
            return false;
        }
    }
}
