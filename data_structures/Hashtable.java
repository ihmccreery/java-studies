class Hashtable {
    private boolean[] store;

    Hashtable() {
        store = new boolean[17];
        for (int i = 0; i < store.length; i++) {
            store[i] = false;
        }
    }

    public void insert(int a) {
        store[hash(a)] = true;
    }

    public boolean lookup(int a) {
        return store[hash(a)];
    }

    private int hash(int a) {
        return a % store.length;
    }
}
