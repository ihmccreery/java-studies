class Lookup {
    public static void main(String[] args) {
        AVL<Integer> t = new AVL<Integer>();
        int[] nums = {2, 8, 4, 6, 14, 12, 10, 24, 60, 8, 16, 32, 24, 52, 80, 40, 18, 0};

        for (int i = 0; i < nums.length; i++) {
            t.insert(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(t.lookup(nums[i]) + " should be true.");
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(t.lookup(nums[i]+1) + " should be false.");
        }
    }
}
