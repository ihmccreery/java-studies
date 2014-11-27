class Quicksorter {
    public static void sort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    // sort a from a[i] to a[k], inclusive
    private static void quicksort(int[] a, int i, int k) {
        if (i < k) {
            int p = partition(a, i, k);
            quicksort(a, i, p-1);
            quicksort(a, p+1, k);
        }
    }

    // partition a from a[i] to a[k], inclusive
    private static int partition(int[] a, int i, int k) {
        int p = pivot(i, k);
        swap(a, p, k);
        int pivot_value = a[k];
        int pivot_index = i;
        for (int j = i; j < k; j++) {
            if (a[j] < pivot_value) {
                swap(a, pivot_index, j);
                pivot_index++;
            }
        }
        swap(a, pivot_index, k);
        return pivot_index;
    }

    // swap a[i] and a[j]
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // find pivot from a[i] to a[k], inclusive
    private static int pivot(int i, int k) {
        return k;
    }
}
