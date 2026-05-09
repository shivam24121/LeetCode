class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int n=grid.length;
        int m=grid[0].length;

        int layer=Math.min(n,m)/2;

        for(int x=0;x<layer;x++){

            ArrayList<Integer>list=new ArrayList<>();

            int top=x;
            int right=m-x-1;
            int down=n-x-1;
            int left=x;

            for(int i=left;i<=right;i++){
                list.add(grid[top][i]);
            }
            for(int i=top+1;i<=down;i++){
                list.add(grid[i][right]);
            }
            for(int i=right-1;i>=left;i--){
                list.add(grid[down][i]);
            }
            for(int i=down-1;i>top;i--){
                list.add(grid[i][left]);
            }
            int rotate=k%list.size();
            Collections.rotate(list,-rotate);
            int idx=0;

            for(int i=left;i<=right;i++){
                grid[top][i]=list.get(idx++);
            }
            for(int i=top+1;i<=down;i++){
                grid[i][right]=list.get(idx++);
            }
            for(int i=right-1;i>=left;i--){
                grid[down][i]=list.get(idx++);
            }
            for(int i=down-1;i>top;i--){
                grid[i][left]=list.get(idx++);
            }
        }
        return grid;
    }
}
