class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);
        int n=cost.length;

        int res=0;
        int ct=0;

        for(int i=n-1;i>=0;i--){
            if(ct==2){
                ct=0;
                continue;
            }
            res+=cost[i];
            ct++;
        }
        return res;
    }
}
