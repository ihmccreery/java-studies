class Sorter {
    public static void main(String[] args) {
        int[] a = {2, 5, 7, 4, 1, 3, 9, 0, 6, 8};

        Mergesorter.sort(a);

        printArray(a);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
