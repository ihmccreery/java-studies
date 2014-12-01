class Hashtable {
    private LinkedList[] store;
    private int numEntries;

    Hashtable() {
        this.store = new LinkedList[4];
        this.numEntries = 0;
        for (int i = 0; i < this.store.length; i++) {
            this.store[i] = new LinkedList();
        }
    }

    public void insert(int a) {
        this.store[hash(a)].insert(a);
        this.numEntries++;
        if (loadFactor() > 0.75) {
            resize();
        }
    }

    public boolean lookup(int a) {
        return this.store[hash(a)].lookup(a);
    }

    private int hash(int a) {
        return a % this.store.length;
    }

    private float loadFactor() {
        return this.numEntries / (float) this.store.length;
    }

    private void resize() {
        LinkedList[] oldStore = this.store;
        this.store = new LinkedList[this.store.length*2];
        for (int i = 0; i < this.store.length; i++) {
            this.store[i] = new LinkedList();
        }
        for (int i = 0; i < oldStore.length; i++) {
            int[] values = oldStore[i].values();
            for (int j = 0; j < values.length; j++) {
                insert(values[j]);
            }
        }
    }
}
