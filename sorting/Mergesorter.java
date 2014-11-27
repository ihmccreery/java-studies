class Mergesorter {
    public static void sort(int[] a) {
        int[] tmp = new int[a.length];
        mergesort(a, tmp, 0, a.length);
    }

    // sort a from a[i] to a[k], exclusive of a[k]
    private static void mergesort(int[] a, int[] tmp, int i, int k) {
        if (i < k-1) {
            int p = pivot(i, k);
            mergesort(a, tmp, i, p);
            mergesort(a, tmp, p, k);
            merge(a, tmp, i, p, k);
        }
    }

    // merge a[i] to a[p] and a[p] to a[k]
    private static void merge(int[] a, int[] tmp, int i, int p, int k) {
        int x = i;
        int y = p;
        int m = i;
        while (x < p && y < k) {
            if (a[x] < a[y]) {
                tmp[m] = a[x];
                m++;
                x++;
            } else {
                tmp[m] = a[y];
                m++;
                y++;
            }
        }
        if (x == p) {
            while (y < k) {
                tmp[m] = a[y];
                m++;
                y++;
            }
        } else {
            while (x < p) {
                tmp[m] = a[x];
                m++;
                x++;
            }
        }
        // copy values back
        for (int j = i; j < k; j++) {
            a[j] = tmp[j];
        }
    }

    // find pivot from a[i] to a[k], exclusive of a[k]
    private static int pivot(int i, int k) {
        return i + (k - i)/2;
    }
}
