class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] t=new int[amount+1];
        Arrays.fill(t,amount+1);
        t[0]=0;

        for(int i=1;i<=amount;i++){
            for(int j:coins){
                if(j<=i){
                    t[i]=Math.min(t[i],t[i-j]+1);
                }
            }
        }
        return t[amount]>amount?-1:t[amount];
    }
}
