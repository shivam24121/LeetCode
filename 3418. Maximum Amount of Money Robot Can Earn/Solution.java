class Solution {

    int n;
    int m;

    int[][][] dp;

    public int maximumAmount(int[][] grid) {
        
        n=grid.length;
        m=grid[0].length;

        dp=new int[n][m][3];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,Integer.MIN_VALUE);
            }
        }
        return solve(0,0,2,grid);
    }
    public int solve(int x,int y,int k,int[][] grid){
        
        if(x==n-1 && y==m-1){
            return grid[x][y]<0 && k>0?0:grid[x][y];
        }

        if(dp[x][y][k]!=Integer.MIN_VALUE){
            return dp[x][y][k];
        }

        int right=Integer.MIN_VALUE;
        int down=Integer.MIN_VALUE;

        if(grid[x][y]>=0 || k==0){

            if(y+1<m) right=Math.max(right,grid[x][y]+solve(x,y+1,k,grid));
            if(x+1<n) down=Math.max(down,grid[x][y]+solve(x+1,y,k,grid));
        }

        else{

            if(y+1<m){

                right=Math.max(right,Math.max((grid[x][y]+solve(x,y+1,k,grid)),(k>0)?solve(x,y+1,k-1,grid):Integer.MIN_VALUE));
            }

            if(x+1<n){

                down=Math.max(down,Math.max((grid[x][y]+solve(x+1,y,k,grid)),(k>0)?solve(x+1,y,k-1,grid):Integer.MIN_VALUE));
            }
        }
        return dp[x][y][k]=Math.max(right,down);
    }
}
