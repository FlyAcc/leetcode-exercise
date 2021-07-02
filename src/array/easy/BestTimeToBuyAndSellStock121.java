package array.easy;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock121 maxProfit121 = new BestTimeToBuyAndSellStock121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit121.maxProfit(prices));
        System.out.println(maxProfit121.maxProfit_OnePass(prices));
    }

    /*
    最大收益为剩余部分的最大价格减去当前价格
    Note：当前部分的最大价格为Max（当前元素，下一部分的最大价格）
     */
    public int maxProfit(int[] prices) {
        int restMax = prices[prices.length - 1];
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            // 更新剩余部分的最大价格
            restMax = Math.max(restMax, prices[i + 1]);
            maxProfit = Math.max(maxProfit, restMax - prices[i]);
        }

        return maxProfit;
    }

    /*
    最大收益为Min（极大值-极小值），其中极小值每次的取值应该比上一个极小值小
     */
    public int maxProfit_OnePass(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            // 更新极小值
            if (price < minPrice)
                minPrice = price;
                // 计算最大收益
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
    }
}
