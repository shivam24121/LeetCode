class Solution {

    int[][] dp;
    public int maxHeight(int[][] cube) {

        int n=cube.length;

        for(int i=0;i<n;i++){
            Arrays.sort(cube[i]);
        }
        Arrays.sort(cube,(a,b)->{
            if(a[2]!=b[2]){
                return a[2]-b[2];
            }
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
    
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<3;j++){
        //         System.out.print(cube[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        dp=new int[n+1][n+1];
        for(int[] e:dp){
            Arrays.fill(e,-1);
        }
        return solve(0,-1,cube);
    }
    public int solve(int idx, int prev, int[][] cube){

        if(idx==cube.length)return 0;

        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];

        int skip=solve(idx+1,prev,cube);

        int take=0;

        if(prev==-1 || cube[idx][0]>=cube[prev][0] && cube[idx][1]>=cube[prev][1] 
                                                   && cube[idx][2]>=cube[prev][2]){
            
            take=cube[idx][2]+solve(idx+1,idx,cube);

        }
        return dp[idx][prev+1]=Math.max(take,skip);
    }
}
