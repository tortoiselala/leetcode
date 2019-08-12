package hard;

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int len = prices.length, max = 0;
        for(int i = 0; i < len; ++i){
            int sum = opt(prices, 0, i) + opt(prices, i, len - 1);
            max = sum > max ? sum : max;
        }
        return max;
    }
    private int opt(int[] prices, int i, int j) {
        int minPrice = prices[i], maxPrifits = 0;
        for(int k = i; k <= j; ++k){
            if(prices[k] <= minPrice){
                minPrice = prices[k];
            }else if(prices[k] - minPrice > maxPrifits){
                maxPrifits = prices[k] - minPrice;
            }
        }
        return maxPrifits;
    }
}
