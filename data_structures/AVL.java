class AVL {
    Data data;
    int height;
    AVL left;
    AVL right;

    public AVL() {
        height = 0;
    }

    public AVL insert(int a) {
        if (data == null) {
            data = new Data(a);
            height = 1;
            left = new AVL();
            right = new AVL();
            return this;
        } else if (a < data.data) {
            left = left.insert(a);
            return rebalance();
        } else if (a > data.data) {
            right = right.insert(a);
            return rebalance();
        } else { // a == data.data
            return this;
        }
    }

    private AVL rebalance() {
        if (lean() > 1) { // left
            if (left.lean() < 0) { // left-right, correct to left-left
                left = left.rotate_left();
            }
            return rotate_left();
        } else if (lean() < -1) { // right
            if (right.lean() > 0) { // right-left, correct to right-right
                right = right.rotate_right();
            }
            return rotate_right();
        } else {
            return this;
        }
    }

    private AVL rotate_left() {
        AVL x = this.right;
        AVL y = x.left;
        x.left = this;
        this.right = y;
        return x;
    }

    private AVL rotate_right() {
        AVL x = this.left;
        AVL y = x.right;
        x.right = this;
        this.left = y;
        return x;
    }

    private int lean() {
        return left.height - right.height;
    }

    public boolean lookup(int a) {
        if (data == null) {
            return false;
        } else if (a < data.data) {
            return left.lookup(a);
        } else if (a > data.data) {
            return right.lookup(a);
        } else { // a == data.data
            return true;
        }
    }

    private class Data {
        int data;

        Data(int a) {
            data = a;
        }
    }
}
