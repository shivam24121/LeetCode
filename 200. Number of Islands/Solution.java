class Solution {
    ArrayList<int[]> l=new ArrayList<>();
    Solution(){
        l.add(new int[]{1,0});
        l.add(new int[]{-1,0});
        l.add(new int[]{0,1});
        l.add(new int[]{0,-1});
    }
    public void dfs(char[][] grid , int i,int j){
        if(i<0 || i>=grid.length ||j<0 || j>=grid[0].length || grid[i][j]!='1')return;
        grid[i][j]='@';
        for(int[] a:l){
            int ii=i+a[0];
            int jj=j+a[1];
            dfs(grid,ii,jj);
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        } 
        return res;
    }
}
