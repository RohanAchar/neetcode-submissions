class Solution {
    public int maxProfit(int[] prices) {
        // Edge case: if there are fewer than 2 days, no profit can be made
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0]; // Track the lowest buying price seen so far
        int maxProfit = 0;        // Track the maximum profit found

        // Iterate through the prices starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // If the current price is lower than our minPrice, update it
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Otherwise, check if selling today yields a higher profit
            else {
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }
}
