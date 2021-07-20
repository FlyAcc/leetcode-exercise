/**
 * https://leetcode.com/problems/coin-change
 * 该题给出一个数组，以及一个数amount，目标是是使用最少的数组元素使其和为amount
 * 由于无法使用greedy，因此我们需要全部计算一遍，但是这个过程可以使用dp提高计算效率
 * （考虑到迭代关系minNum(amount) = minNum(amount - coin) + 1, 故可以使用dp)
 * tags: #DP
 */
public class CoinChange322 {
    public static void main(String[] args) {
        CoinChange322 c = new CoinChange322();
        System.out.println(c.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(c.coinChange_BottomUp(new int[]{186, 419, 83, 408}, 6249));
    }

    /*
    https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations
    @wang4249
     */
    public int coinChange_BottomUp(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && count[i - coin] >= 0) {
                    min = Math.min(count[i - coin] + 1, min);
                }
            }
            count[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return count[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        return coinChange_TopDown(coins, amount, new int[amount + 1]);
    }

    /*
    https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations
     */
    private int coinChange_TopDown(int[] coins, int amount, int[] count) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (count[amount] != 0) {
            return count[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = coinChange_TopDown(coins, amount - coin, count);
            if (num >= 0) {
                min = Math.min(num + 1, min);
            }
        }

        count[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount];
    }
}
