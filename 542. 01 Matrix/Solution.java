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

    int m;
    int n;

    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;

        Queue<Pair> q=new LinkedList<>();
        int[][] res=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                    q.add(new Pair(i,j));
                }
                else{
                    res[i][j]=-1;            // helps in queue case condition;
                }
            }
        }

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int x=curr.one;
            int y=curr.two;

            for(int i=0;i<4;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];

                if(xx>=0 && xx<m && yy>=0 && yy<n && res[xx][yy]==-1){
                    res[xx][yy]=res[x][y]+1;
                    q.add(new Pair(xx,yy));
                }
            }
        }
        return res;
    }
}
