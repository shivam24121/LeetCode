class Solution {

    int[] dx={1,0,0,-1};
    int[] dy={0,1,-1,0};

    public boolean findSafeWalk(List<List<Integer>> grid, int k) {
        
        int n=grid.size();
        int m=grid.get(0).size();

        int start=grid.get(0).get(0);

        if(start>=k){
            return false;
        }

        boolean[][] vis=new boolean[n][m];
        vis[0][0]=true;

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,start});

        while(!pq.isEmpty()){

            int[] curr=pq.poll();
            int x=curr[0];
            int y=curr[1];
            int w=curr[2];

            if(w>=k)continue;

            if(x==n-1 && y==m-1){
                return w<k;
            }

            for(int i=0;i<4;i++){
                int newX=x+dx[i];
                int newY=y+dy[i];

                if(newX<0 || newX==n || newY<0 || newY==m || vis[newX][newY]){
                    continue;
                }
                int newW=w+grid.get(newX).get(newY);

                if(newW>=k){
                    continue;
                }

                pq.offer(new int[]{newX,newY,newW});
                vis[newX][newY]=true;
            }
        }
        return false;
    }
}
