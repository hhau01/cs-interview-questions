/*
    The cost of stock on each day is given in an array. Find the max profit that you can make by buying and selling in those days.

    E.g. array = {100, 180, 260, 310, 40, 535, 695}
    
    Max profit can be earned by buying on day 0 and selling on day 3. Then buying on day 4 and selling on day 6.
    If array is sorted in descending order then profit cannot be earned at all.
*/

import java.util.ArrayList;

public class BuySellStocksMaxProfit {
    public static class StockNode {
        int buy, sell;
    }

    public static class BuySellStock {
        public void buySellStock(int[] price, int n) {
            if (n == 1) return;

            int count = 0;

            ArrayList<StockNode> solution = new ArrayList<StockNode>();

            int i = 0;

            while (i < n - 1) {
                while ((i < n - 1) && (price[i + 1] <= price[i])) {
                    i++;
                }

                if (i == n - 1) break;

                StockNode node = new StockNode();
                node.buy = i++;

                while ((i < n) && (price[i] >= price[i - 1])) {
                    i++;
                }

                node.sell = i - 1;
                solution.add(node);

                count++;
            }
            if (count == 0) {
                System.out.println("No possible profit to be made.");
            }

            else {
                for (int j = 0; j < count; j++) {
                    System.out.println("Buy on day: " + solution.get(j).buy
                                       + " Sell on day: " + solution.get(j).sell);
                }
            }
        }
    }

    public static void main(String[] args) {
        BuySellStock stock = new BuySellStock();

        // int[] price = {100, 180, 260, 310, 40, 535, 695};
        // int[] price = {100, 180, 260, 310, 40, 535, 695};
        // int[] price = {10,9,8,7,6,5,4,3};
        int[] price = {2,3,4,5,1000,1,1,1};
        
        int n = price.length;

        stock.buySellStock(price, n);
    }
}