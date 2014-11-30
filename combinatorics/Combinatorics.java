class Combinatorics {
    public static void main(String[] args) {
        System.out.println(chooseWrong(8, 3) == choose(8, 3));
        System.out.println(chooseWrong(20, 5) == choose(20, 5)); // choose overflows here
    }

    private static int choose(int n, int k) {
        if (k == 0) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return n * choose(n-1, k-1) / k;
        }
    }

    private static int chooseWrong(int n, int k) {
        return factorial(n) / (factorial(n-k) * factorial(k));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
