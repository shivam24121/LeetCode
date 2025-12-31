class Solution {

    int Row,Col;
    int[] dx={1,0,0,-1};
    int[] dy={0,-1,1,0};

    public int latestDayToCross(int row, int col, int[][] cells) {
        Row=row;
        Col=col;

        int l=0,r=cells.length-1;
        int res=0;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(cells,mid)){
                res=mid+1;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    public boolean valid(int[][] cells,int mid){
        int[][] grid=new int[Row][Col];

        for(int i=0;i<=mid;i++){
            int one=cells[i][0]-1;
            int two=cells[i][1]-1;
            
            grid[one][two]=1;
        }
        for(int i=0;i<Col;i++){
            if(grid[0][i]==0 && dfs(grid,0,i)){
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int[][] grid,int x,int y){
        if(x<0 || x>=Row || y<0 || y>=Col || grid[x][y]!=0){
            return false;
        }
        if(x==Row-1)return true;

        grid[x][y]=1;

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(dfs(grid,xx,yy))return true;
        }
        return false;
    }
}
