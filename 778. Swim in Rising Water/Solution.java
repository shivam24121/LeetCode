class Solution {
    int n;
    boolean[][] check;
    int[] dirX={1,0,0,-1};
    int[] dirY={0,-1,1,0};

    public int swimInWater(int[][] grid) {
        n=grid.length;
        int l=grid[0][0],r=n*n-1;
        int res=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            check=new boolean[n][n];
            if(dfs(grid,0,0,mid)){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    public boolean dfs(int[][] grid,int i,int j,int time){
        if(i<0 || i>=n || j<0 || j>=n || check[i][j] || grid[i][j]>time){
            return false;
        }
        check[i][j]=true;

        if(i==n-1 && j==n-1){
            return true;
        }

        for(int x=0;x<4;x++){
            int ii=i+dirX[x];
            int jj=j+dirY[x];
            if(dfs(grid,ii,jj,time)){
                return true;
            }
        }
        return false;
    }
}
