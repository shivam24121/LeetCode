class Solution {
    
    static class Pair{
        int one;
        int two;
        Pair(int x,int y){
            this.one=x;
            this.two=y;
        } 
    }

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<Pair>q=new LinkedList<>();
        
        int fresh=0;
        int time=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)return 0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int x=curr.one;
                int y=curr.two;

                for(int ptr=0;ptr<4;ptr++){
                    int xx=x+dx[ptr];
                    int yy=y+dy[ptr];

                    if(xx>=0 && xx<m && yy>=0 && yy<n && grid[xx][yy]==1){
                        grid[xx][yy]=2;
                        q.offer(new Pair(xx,yy));
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh==0?time-1:-1;
    }
}
