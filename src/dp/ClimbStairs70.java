package dp;

/**
 * 该题实际是斐波那契数列
 * tags: #DP
 */
public class ClimbStairs70 {
    public static void main(String[] args) {
        ClimbStairs70 cs = new ClimbStairs70();
        System.out.println(cs.climbStairs_Memoize(4));
        System.out.println(cs.climbStairs_Memoize(5));
        System.out.println(cs.climbStairs_Memoize(6));
        System.out.println(cs.climbStairs_Memoize(7));
        System.out.println(cs.climbStairs_Memoize(1));
        System.out.println(cs.climbStairs_Memoize(2));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /*
    Fn = [((1+sqrt(5))/2)^n-((1-sqrt(5))/2)^n]/sqrt(5)
    pow(): O(logN)
     */
    public int climeStairs_BinetFormula(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }

    public int climeStairs_BottomUp(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs_Memoize(int n) {
        int[] memoize = new int[n + 1];
        return climbStairs_Memoize(n, memoize);
    }

    private int climbStairs_Memoize(int n, int[] memoize) {
        if (memoize[n] == 0) {
            if (n == 1) {
                memoize[1] = 1;
            } else if (n == 2) {
                memoize[2] = 2;
            } else {
                memoize[n] = climbStairs_Memoize(n - 1, memoize) + climbStairs_Memoize(n - 2, memoize);
            }
        }

        return memoize[n];
    }
}
