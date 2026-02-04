class Solution {

    long[][] dp;
    static final long inf=-(long)1e15;

    // 0 toh not started yet
    // 1 toh inc
    // 2 toh dec
    // 3 toh inc

    public long maxSumTrionic(int[] nums) {
        int n=nums.length;

        dp=new long[n+1][4];

        for(long[] i:dp){
            Arrays.fill(i,Long.MIN_VALUE);
        }
        return solve(0,0,nums);
    }
    public long solve(int idx,int state,int[] nums){

        if(idx>=nums.length){
            if(state==3){
                return 0;
            }
            else{
                return inf;
            }
        }

        if(dp[idx][state]!=Long.MIN_VALUE)return dp[idx][state];

        long pick=inf;
        long skip=inf;

        if(state==3){
            pick=nums[idx];
        }

        if(idx+1<nums.length){

            int curr=nums[idx];
            int next=nums[idx+1];

            if(state==0){
                skip=solve(idx+1,0,nums);

                if(next>curr){
                    pick=curr+solve(idx+1,1,nums);
                }
            }
            else if(state==1){
                if(next>curr){
                    pick=Math.max(pick,curr+solve(idx+1,1,nums));
                }
                else if(next<curr){
                    pick=Math.max(pick,curr+solve(idx+1,2,nums));
                }
            }
            else if(state==2){
                if(next<curr){
                    pick=Math.max(pick,curr+solve(idx+1,2,nums));
                }
                else if(next>curr){
                    pick=Math.max(pick,pick=curr+solve(idx+1,3,nums));
                }
            }
            else if(state==3){

                if(curr<next){
                    pick=Math.max(pick,nums[idx]+solve(idx+1,3,nums));
                }
            }
        }
        return dp[idx][state]=Math.max(pick,skip);
    }
}
