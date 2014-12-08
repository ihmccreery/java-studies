class Quicksorter {
    public static void sort(int[] a) {
        quicksort(a, 0, a.length-1);
    }

    private static void quicksort(int[] a, int start, int end) {
        if (start < end) {
            int pivot = partition(a, start, end);
            quicksort(a, start, pivot-1);
            quicksort(a, pivot+1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        swap(a, pivot(start, end), end); // move pivot to the end
        int pval = a[end]; // pivot value
        int j = start; // this points to the first j | j >= pval
        for (int i = start; i < end; i++) {
            if (a[i] < pval) {
                swap(a, i, j);
                j++;
            }
        }
        swap(a, end, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int pivot(int start, int end) {
        return start + (end-start)/2;
    }
}
