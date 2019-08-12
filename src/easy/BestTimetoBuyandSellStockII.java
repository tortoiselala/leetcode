package easy;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        return peakValleyApproach(prices);
    }

    // Time limited
    private int maxProfitCustom(int[] prices) {
        int len = prices.length;
        int[][] opt = new int[len][len];
        for(int i = 0; i < len - 1; ++i){
            int sub = prices[i + 1] - prices[i];
            opt[i][i + 1] = sub > 0 ? sub : 0;
        }
        for(int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; j++) {
                for (int k = i; k <= j ; k++) {
                    opt[i][j] = Integer.max(opt[i][j], opt[i][k] + opt[k][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Integer.max(opt[i][len - 1], max);
        }
        return max;
    }

    private int oneLine(int[] prices){
        int len = prices.length;
        int count = 0;
        for(int i = 0; i < len - 1; ++i) {
            int sub = prices[i + 1] - prices[i];
            if(sub > 0){
                count += sub;
            }
        }
        return count;
    }

    private int peakValleyApproach(int[] prices){
        int len = prices.length;
        if(len == 0){
            return 0;
        }
        int count  = 0;
        int i = 0;
        int low = prices[0];
        int high = prices[0];
        while(i < len - 1){
            while(i + 1 < len && prices[i] >= prices[i + 1]){
                ++i;
            }

            low = prices[i];

            while (i + 1 < len && prices[i] <= prices[i + 1]){
                ++i;
            }

            high = prices[i];
            count += high - low;
        }
        return count;
    }
}
