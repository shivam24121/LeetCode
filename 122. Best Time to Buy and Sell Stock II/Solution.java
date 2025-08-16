class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0,temp=0;
        for(int i=1;i<prices.length;i++){
            if(min<prices[i]){
                temp=prices[i]-min;
                profit+=temp;
                min=prices[i];
            }
            else{
                min=prices[i];
            }
        }
        return profit;
    }
}
