class Solution {

    int[][][] dp;
    int n,m;
    
    public int minCost(int[][] grid) {

        n=grid.length;
        m=grid[0].length;

        dp=new int[n][m][1024];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,Integer.MAX_VALUE);
            }
        }
        for(int i=0;i<1024;i++){
            if(solve(0,0,i,grid)==1){
                return i;
            }
        }
        return 0;
    }
    public int solve(int x,int y,int k,int[][] grid){

        if(x<0 || x==n || y<0 || y==m)return 0;
        
        if(x==n-1 && y==m-1){
            return (grid[x][y]==k)?1:0;
        }
        if(dp[x][y][k]!=Integer.MAX_VALUE){
            return dp[x][y][k];
        }
        int next=k^grid[x][y];
        
        int down=(solve(x+1,y,next,grid));
        int right=(solve(x,y+1,next,grid));

        int temp=(down==1 || right==1)?1:0;
        return dp[x][y][k]=temp;
    }
}
