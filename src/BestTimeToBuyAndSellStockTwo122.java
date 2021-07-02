/**
 * tags: #Greedy
 */
public class BestTimeToBuyAndSellStockTwo122 {
    /*
    该题关键在于可多次交易，通过画图可以发现最大的收益实际就是每个极大值和极小值之差的和，
    我们只要找出所有的极大值极小值便可求出最大收益
     */
    public int maxProfit(int[] prices) {
        int buyDay = 0;
        int sellDay = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 此时，sellDay为极大值
            if (prices[i] <= prices[sellDay]) {
                maxProfit += Math.max(0, prices[sellDay] - prices[buyDay]);
                buyDay = i;
            }
            sellDay = i;
        }

        return maxProfit + Math.max(0, prices[sellDay] - prices[buyDay]);
    }

    /*
    实际上，对于2，4，6，10来说，10 - 2 = （4 - 2）+ （6 - 4） + （10 - 6）
    因此我们不需要记录极大极小值
     */
    public int maxProfit_OnePass(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
