class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyStocks = Integer.MAX_VALUE;

        for (int price : prices) {
            buyStocks = Math.min(buyStocks, price);
            profit = Math.max(profit, price - buyStocks);
        }
        return profit;
    }
}
