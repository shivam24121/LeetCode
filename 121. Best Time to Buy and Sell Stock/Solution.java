class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=min){
                int profit=prices[i]-min;
                res=Math.max(res,profit);
            }
            else{
                min=prices[i];
            }
        }
        return res;
    }
}
