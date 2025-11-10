class Solution {

    int[][][] t;
    int n;

    public int cherryPickup(int[][] grid) {
        n=grid.length;
        t=new int[n][n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    t[i][j][k]=-1;
                }
            }
        }
        return Math.max(0,solve(grid,0,0,0));
    }
    public int solve(int[][] grid,int r1,int c1,int r2){
        int c2=(r1+c1)-r2;
        if(r1>=n || r2>=n || c1>=n || c2>=n ||
           grid[r1][c1]==-1 || grid[r2][c2]==-1) return Integer.MIN_VALUE;

        if(r1==n-1 && c1==n-1)return grid[r1][c1];

        if(t[r1][c1][r2]!=-1)return t[r1][c1][r2];

        int curr=0;
        if(r1==r2 && c1==c2){
            curr+=grid[r1][c1];
        }
        else{
            curr+=grid[r1][c1]+grid[r2][c2];
        }

        int next=Math.max(
            Math.max(solve(grid,r1+1,c1,r2),solve(grid,r1+1,c1,r2+1)),
            Math.max(solve(grid,r1,c1+1,r2),solve(grid,r1,c1+1,r2+1))
        );
        
        return t[r1][c1][r2]=curr+next;
    }
}
