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
        swap(a, pivot(start, end), end);
        int pivot_value = a[end];
        int pivot = start;
        for(int i = start; i < end; i++) {
            if (a[i] < pivot_value) {
                swap(a, i, pivot);
                pivot++;
            }
        }
        swap(a, pivot, end);
        return pivot;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int pivot(int start, int end) {
        return end;
    }
}
