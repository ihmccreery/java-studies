class Quicksorter {
    public static void sort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    // quicksort a[i] to a[k], inclusive
    private static void quickSort(int[] a, int i, int k) {
        if (i < k) {
            int p = partition(a, i, k);
            quickSort(a, i, p-1);
            quickSort(a, p+1, k);
        }
    }

    // partition a[i] to a[k], inclusive
    private static int partition(int[] a, int i, int k) {
        // get pivot value out of the way
        swap(a, pivot(i, k), k);
        // record pivotValue
        int pivotValue = a[k];
        // for j from i to k-1
        int pivotLocation = i;
        for (int j = i; j < k; j++) {
            if (a[j] < pivotValue) {
                swap(a, pivotLocation, j);
                pivotLocation++;
            }
        }
        swap(a, pivotLocation, k);
        return pivotLocation;
    }

    // swap elements i and j
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // choose a pivot: just stick to the last index for now
    private static int pivot(int i, int k) {
        return i + (k - i)/2;
    }
}
