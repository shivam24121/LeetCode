class Solution {

    int[][] dp;
    int min=Integer.MAX_VALUE;
    
    public int maximumSaleItems(int[][] arr, int price) {

        int n=arr.length;

        int[] pre=new int[n];

        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i][1]);
            int ct=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(arr[j][0]%arr[i][0]==0){
                    ct++;
                }
            }
            pre[i]=ct;
        }
        dp=new int[n+1][1500+1];

        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,price,arr,pre);
    }
    public int solve(int idx,int price,int[][] arr,int[] pre){

        if(idx==arr.length){
            return price/min;
        }
        if(dp[idx][price]!=-1){
            return dp[idx][price];
        }

        int skip=solve(idx+1,price,arr,pre);

        int pick=0;

        if(arr[idx][1]<=price){
            pick=pre[idx]+1+solve(idx+1,price-arr[idx][1],arr,pre);
        }
        return dp[idx][price]=Math.max(pick,skip);
    }
}
