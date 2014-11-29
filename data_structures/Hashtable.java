class Hashtable {

    private boolean[] Store;

    Hashtable() {
        Store = new boolean[17];
        for (int i = 0; i < Store.length; i++) {
            Store[i] = false;
        }
    }

    public void insert(int a) {
        Store[hash(a)] = true;
    }

    public boolean lookup(int a) {
        return Store[hash(a)];
    }

    private int hash(int a) {
        return a % Store.length;
    }
}
