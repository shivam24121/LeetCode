// note that using 2 lines we can create 3 rectangles

class Solution {

    //total 6 cases are there but we will check only 3 cases and for rest other 3 
    // we will just rotate those 3

    public int[][] rotate(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] rt=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rt[j][m-i-1]=grid[i][j];
            }
        }
        return rt;
    }

    // function to calculate the minnmum area

    public int minarea(int rowst,int rowed,int colst,int coled,int[][]grid){
        int m=grid.length;
        int n=grid[0].length;

        int minrow=m;
        int maxrow=-1;
        int mincol=n;
        int maxcol=-1;

        for(int i=rowst;i<rowed;i++){
            for(int j=colst;j<coled;j++){
                if(grid[i][j]==1){
                    minrow=Math.min(minrow,i);
                    maxrow=Math.max(maxrow,i);
                    mincol=Math.min(mincol,j);
                    maxcol=Math.max(maxcol,j);
                }
            }
        }
        if(maxrow==-1)return 0;
        return (maxrow-minrow+1)*(maxcol-mincol+1);
    }

    // those 3 cases 

    public int utility(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int res=Integer.MAX_VALUE;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int top=minarea(0,i,0,n,grid);
                int bottom_left=minarea(i,m,0,j,grid);
                int bottom_right=minarea(i,m,j,n,grid);
                res=Math.min(res,top+bottom_left+bottom_right);
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int top_left=minarea(0,i,0,j,grid);
                int top_right=minarea(0,i,j,n,grid);
                int bottom=minarea(i,m,0,n,grid);
                res=Math.min(res,top_left+top_right+bottom);
            }
        }
        for(int i=1;i<m;i++){
            for(int j=i+1;j<m;j++){
                int up=minarea(0,i,0,n,grid);
                int mid=minarea(i,j,0,n,grid);
                int down=minarea(j,m,0,n,grid);
                res=Math.min(res,up+mid+down);
            }
        }
        return res;
    }

    // check the min of our 3 cases and then the rotated one (the remaining 3 cases);
    
    public int minimumSum(int[][] grid) {
        int res=utility(grid);
        int[][] rotated=rotate(grid);
        res=Math.min(res,utility(rotated));
        return res;
    }
}
