package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimetoBuyandSellStockTest {

    @Test
    public void maxProfit() {
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{2, 4, 1}));
    }
}