class Solution {
    /*
     * Keep track of the minimum stock price seen so far, because it is the
     * best day to buy before the current day.
     *
     * For every current price, assume we sell today:
     * profit = currentPrice - minimumPriceSeenSoFar.
     *
     * Update the maximum profit with this possible profit. If prices only
     * decrease, maxProfit remains 0, meaning we do not make a transaction.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPriceSoFar = Math.min(minPriceSoFar, price);
            maxProfit = Math.max(maxProfit, price - minPriceSoFar);
        }

        return maxProfit;
    }
}