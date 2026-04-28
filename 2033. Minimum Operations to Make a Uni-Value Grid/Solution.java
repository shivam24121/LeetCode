class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        ArrayList<Integer>list=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
…        for(int i=0;i<n;i++){
            int diff=Math.abs(list.get(i)-target);
            if(diff%x!=0){
                return -1;
            }
            res+=diff/x;
        }
        return res;
    }
}
