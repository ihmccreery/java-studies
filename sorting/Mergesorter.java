class Mergesorter {
    public static void sort(int[] a) {
        mergesort(a, new int[a.length], 0, a.length);
    }

    // sort from a[i] to a[k], not inclusive of a[k]
    private static void mergesort(int[] a, int[] tmp, int i, int k) {
        if (i < k-1) {
            int p = pivot(i, k);
            mergesort(a, tmp, i, p);
            mergesort(a, tmp, p, k);
            merge(a, tmp, i, p, k);
        }
    }

    // merge from a[i] to a[k], not inclusive of a[k]
    private static void merge(int[] a, int[] tmp, int i, int p, int k) {
        int j = i;
        int l = p;
        int m = i;
        // merge the two lists until one runs out
        while (j < p && l < k) {
            if (a[j] < a[l]) {
                tmp[m] = a[j];
                j++;
                m++;
            } else {
                tmp[m] = a[l];
                l++;
                m++;
            }
        }
        // clean up the other list
        while (j < p) {
            tmp[m] = a[j];
            j++;
            m++;
        }
        while (l < k) {
            tmp[m] = a[l];
            l++;
            m++;
        }
        // copy back from tmp to a
        for (j = i; j < k; j++) {
            a[j] = tmp[j];
        }
    }

    private static int pivot(int i, int k) {
        return i + (k - i)/2;
    }
}
