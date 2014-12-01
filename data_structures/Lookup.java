class Lookup {
    public static void main(String[] args) {
        LinkedList t = new LinkedList();
        int[] nums = {1, 2, 4, 5, 6, 8, 11, 14, 12, 10, 5, 5, 1, 0};

        for (int i = 0; i < nums.length; i++) {
            t.insert(nums[i]);
        }

        System.out.println(t.lookup(6) + " should be true.");
        System.out.println(t.lookup(13) + " should be false.");
    }
}
