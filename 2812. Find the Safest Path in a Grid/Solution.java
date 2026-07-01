class Solution {

    int n;
    int[] dx={1,0,0,-1};
    int[] dy={0,1,-1,0};

    public boolean valid(int[][] dist,int mid){

        Queue<int[]>q=new ArrayDeque<>();
        boolean[][] vis=new boolean[n][n];

        if(dist[0][0]<mid){
            return false;
        }

        q.offer(new int[]{0,0});
        vis[0][0]=true;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){

                int[] curr=q.poll();
                int currX=curr[0];
                int currY=curr[1];

                if(currX==n-1 && currY==n-1){
                    return true;
                }

                for(int j=0;j<4;j++){
                    int nextX=currX+dx[j];
                    int nextY=currY+dy[j];

                    if(nextX<0 || nextY<0 || nextY==n || nextX==n || dist[nextX][nextY]<mid){
                        continue;
                    }
                    if(vis[nextX][nextY]==true){
                        continue;
                    }

                    vis[nextX][nextY]=true;
                    q.offer(new int[]{nextX,nextY});
                }
            }
        }
        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        

        n=grid.size();
        
        boolean[][] vis=new boolean[n][n];
        int[][] dist=new int[n][n];
        Queue<int[]>q=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    q.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        int lvl=0;

        while(!q.isEmpty()){

            int size=q.size();

            for(int i=0;i<size;i++){

                int[] curr=q.poll();
                int currX=curr[0];
                int currY=curr[1];

                dist[currX][currY]=lvl;

                for(int j=0;j<4;j++){
                    int nextX=currX+dx[j];
                    int nextY=currY+dy[j];

                    if(nextX<0 || nextX==n || nextY<0 || nextY==n || vis[nextX][nextY]==true){
                        continue;
                    }
                    q.offer(new int[]{nextX,nextY});
                    vis[nextX][nextY]=true;
                }
            }
            lvl++;
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int l=0;
        int r=400;

        int ans=0;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(dist,mid)){
                ans=mid;
                // System.out.println("valid mid "+mid);
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}
