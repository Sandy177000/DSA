
public class best_time_for_stocks {
    //Type 1: one time buy and sell
    public int maxProfit(int[] prices) {

        int max = 0 ;
        int n = prices.length;
        //two pointer method
        int i = 0;
        int j = 1;

        while(j<n){
            if(prices[i]<prices[j]){
                max = Math.max(prices[j]-prices[i],max);
                j++;
            }
            else{
                i = j;
                j++;
            }
           
        }

        return max;

    }

    //Type 2 : Multiple buying and selling
     public int maxProfit2(int[] prices) {
        
         int profit = 0;
         for(int i=1;i<prices.length;i++){
             // If price of curr day is higher than the previous day 
             // add the price difference into our profit

             if(prices[i]>prices[i-1]){
                 profit += prices[i] - prices[i-1];
             }
         }

         return profit;
    }
    
    //Type 3: Return  the days of buying and selling
    
}