class Solution {

    int[][][] dp;
    int n;
    int m;

    public boolean hasValidPath(char[][] grid) {
        
        n=grid.length;
        m=grid[0].length;

        dp=new int[n+1][m+1][n+m+1];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }

        return solve(0,0,0,grid);
    }
    public boolean solve(int x,int y,int val,char[][] arr){

        if(x<0 || x==n || y<0 || y==m){
            return false;
        }
        if(x==n-1 && y==m-1){
            if(val==1 && arr[x][y]==')'){
                return true;
            }
            return false;
        }

        if(val<0){
            return false;
        }
        
        if(dp[x][y][val]!=-1){
            return dp[x][y][val]==1?true:false;
        }
    
        int curr=(arr[x][y]==')')?-1:1;

        boolean right=solve(x,y+1,val+curr,arr);

        boolean down=solve(x+1,y,val+curr,arr);

        dp[x][y][val]=(right|down)?1:0;

        return right|down;
    }
}
