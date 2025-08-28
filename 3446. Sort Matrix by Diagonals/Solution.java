class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Map<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                map.putIfAbsent(key,key<0? new PriorityQueue()
                :new PriorityQueue<>(Collections.reverseOrder()));
                map.get(key).offer(grid[i][j]);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                grid[i][j]=map.get(key).poll();
            }
        }
        return grid;
    }
}
