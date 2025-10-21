class Solution {
    public int maxProfit(int[] prices) {
        
        int b1=Integer.MIN_VALUE;
        int p1=0;
        int b2=Integer.MIN_VALUE;
        int p2=0;

        for(int amount:prices){
            b1=Math.max(b1,-amount);           // we start from 0 so to buy we spend prises[i] rupees;
            p1=Math.max(p1,b1+amount);         // we got profit buy1 (abhi neg- hai) + prices[i]; 
            b2=Math.max(b2,p1-amount);         // now to but second time , we subtract prices[i] from p1;
            p2=Math.max(p2,b2+amount);         // we got a profit of buy2 + prices[i];
        }
        return p2;                             // final profit;
    }
}
