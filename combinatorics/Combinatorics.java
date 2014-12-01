class Combinatorics {
    public static void main(String[] args) {
        System.out.println(chooseWrong(8, 3) == choose(8, 3));
        System.out.println(chooseWrong(20, 5) == choose(20, 5)); // choose overflows here
        System.out.println("Probability of drawing a straight: " + pStraight());
        System.out.println("Probability of drawing a pair: " + pPair());
    }

    private static double pStraight() {
        return (9 * 5^4) / (double)choose(52, 5);
    }

    private static double pPair() {
        return (13 * 4 * 3 * choose(12, 3) * 4^3) / (double)choose(52, 5);
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
