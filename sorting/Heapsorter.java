public class Heapsorter {
    public static void sort(int[] a) {
        heapify(a);
        sortify(a);
    }

    // turn an unsorted array into a heap
    private static void heapify(int[] a) {
        // i is the last element in the unsorted list, and will become
        // the first element in the sorted list
        for (int i = a.length-1; i >= 0; i--) {
            sift_down(a, i, a.length-1);
        }
    }

    // turn a heap into a sorted array
    private static void sortify(int[] a) {
        // i is the last element in the heap, and will become
        // the first element in the sorted list
        for (int i = a.length-1; i >= 0; i--) {
            swap(a, 0, i);
            sift_down(a, 0, i-1);
        }
    }

    private static void sift_down(int[] a, int root, int end) {
        int left_child = root*2 + 1;
        int right_child = root*2 + 2;

        // check to make sure we're not going to fall off the edge
        if (left_child > end) {
            return;
        } else if (right_child > end) {
            if (a[left_child] > a[root]) {
                swap(a, root, left_child);
                return;
            } else {
                return;
            }
        }

        // sift down
        if (a[left_child] > a[root] && a[left_child] >= a[right_child]) {
            // sift to left child
            swap(a, root, left_child);
            sift_down(a, left_child, end);
        } else if (a[right_child] > a[root] && a[right_child] >= a[left_child]) {
            // sift to right child
            swap(a, root, right_child);
            sift_down(a, right_child, end);
        } // else do nothing; root is the largest of the three, and we're done
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
