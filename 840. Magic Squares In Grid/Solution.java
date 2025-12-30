class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        if(n<3 || m<3)return 0;

        int ct=0;

        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                if(solve(grid,i,j)){
                    ct++;
                }
            }
        }
        return ct;
    }
    public boolean solve(int[][] grid,int a,int b){
        boolean[] seen=new boolean[10];
        for(int i=a;i<a+3;i++){
            for(int j=b;j<b+3;j++){
                int num=grid[i][j];
                if(num<1 || num>9 || seen[num]){
                    return false;
                }
                seen[num]=true;
            }
        }
        int sum=grid[a][b]+grid[a][b+1]+grid[a][b+2];
        for(int i=0;i<3;i++){
            if(grid[a+i][b]+grid[a+i][b+1]+grid[a+i][b+2]!=sum)return false;
            if(grid[a][b+i]+grid[a+1][b+i]+grid[a+2][b+i]!=sum)return false;
        }
        if(grid[a][b]+grid[a+1][b+1]+grid[a+2][b+2]!=sum)return false;
        if(grid[a][b+2]+grid[a+1][b+1]+grid[a+2][b]!=sum)return false;
        return true;
    }
}
