class Solution {

    int n;
    int m;
    long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        ArrayList<Integer>pos=new ArrayList<>();

        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        Collections.sort(robot);

        for(int i=0;i<factory.length;i++){

            int val=factory[i][0];
            int freq=factory[i][1];

            for(int j=0;j<freq;j++){
                pos.add(val);
            }
        }
        n=robot.size();
        m=pos.size();

        dp=new long[n][m];

        for(long[] a:dp){
            Arrays.fill(a,-1);
        }

        return solve(0,0,robot,pos);
    }
    public long solve(int idx,int fac,List<Integer>robot,ArrayList<Integer>pos){

        if(idx==n){
            return 0;
        }
        if(fac==m){
            return (long)1e15;
        }
        if(dp[idx][fac]!=-1){
            return dp[idx][fac];
        }

        long skip=solve(idx,fac+1,robot,pos);

        long pick=Math.abs(robot.get(idx)-pos.get(fac))+solve(idx+1,fac+1,robot,pos);

        return dp[idx][fac]=Math.min(pick,skip);
    }
}
