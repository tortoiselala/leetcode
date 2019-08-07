package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        return onePass(prices);
    }

    private int bruteForce(int[] prices){
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Integer.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    private int onePassCustom(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        int[] mins = Arrays.copyOf(prices, prices.length);
        int[] maxs = Arrays.copyOf(prices, prices.length);

        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if(prices[i] < mins[i - 1]){
                mins[i] = prices[i];
                maxs[i] = prices[i];
            }else{
                mins[i] = mins[i - 1];
                if(prices[i] > maxs[i - 1]){
                    maxs[i] = prices[i];
                }else{
                    maxs[i] = maxs[i - 1];
                }
            }
            max = Integer.max(max, maxs[i] - mins[i]);
        }
        return max;
    }

    private int onePass(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > max) {
                max = price - minPrice;
            }
        }
        return max;
    }
}
