package hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimetoBuyandSellStockIIITest {

    @Test
    public void maxProfit() {
        System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(new int[]{7,6,4,3,1}));

    }
}