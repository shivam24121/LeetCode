class Solution {
    static class Pair{
        int one;
        int two;
        int dist;
        Pair(int x,int y,int d){
            this.one=x;
            this.two=y;
            this.dist=d;
        }
    }
    int[] dx={1,-1,0,0};
    int[] dy={0,0,-1,1};

    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        int[][] distance=new int[m][n];
        for(int[] i:distance){
            Arrays.fill(i,Integer.MAX_VALUE);
        }

        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int currX=curr.one;
            int currY=curr.two;
            int currDist=curr.dist;

            if(currDist>distance[currX][currY])continue;
            if(currX==m-1 && currY==n-1)return currDist;

            for(int i=0;i<4;i++){
                int xx=currX+dx[i];
                int yy=currY+dy[i];

                if(xx>=0 && xx<m && yy>=0 && yy<n){
                    int diff=Math.abs(heights[xx][yy]-heights[currX][currY]);
                    int temp=Math.max(currDist,diff);

                    if(temp<distance[xx][yy]){
                        distance[xx][yy]=temp;
                        pq.offer(new Pair(xx,yy,temp));
                    }
                }
            }
        }
        return distance[m-1][n-1];
    }
}
