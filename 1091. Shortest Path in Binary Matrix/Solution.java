class Solution {

    static int[] horizontal={1,-1,0,0,1,1,-1,-1};
    static int[] vertical={0,0,1,-1,1,-1,1,-1};

    static class Pair{
        int x;
        int y;
        int dis;
        Pair(int xdis,int ydis,int dis){
            this.x=xdis;
            this.y=ydis;
            this.dis=dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,0,1));
        grid[0][0]=1;

        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(curr.x==n-1 && curr.y==n-1){
                return curr.dis;
            }
            for(int i=0;i<8;i++){
                int xx=curr.x+horizontal[i];
                int yy=curr.y+vertical[i];

                if(xx>=0 && xx<n && yy>=0 && yy<n && grid[xx][yy]==0){
                    grid[xx][yy]=1;
                    q.offer(new Pair(xx,yy,curr.dis+1));
                }
            }
        }
        return -1;
    }
}
