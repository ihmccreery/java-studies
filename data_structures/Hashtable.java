class Hashtable {
    private LinkedList[] store;

    Hashtable() {
        store = new LinkedList[4];
        for (int i = 0; i < store.length; i++) {
            store[i] = new LinkedList();
        }
    }

    public void insert(int a) {
        store[hash(a)].insert(a);
    }

    public boolean lookup(int a) {
        return store[hash(a)].lookup(a);
    }

    private int hash(int a) {
        return a % store.length;
    }
}
