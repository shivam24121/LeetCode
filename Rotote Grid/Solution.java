class Solution {
    public void rotate(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp=grid[i][j];
                grid[i][j]=grid[j][i];
                grid[j][i]=temp;
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int l=0,r=m-1;

        while(l<r){
            for(int i=0;i<n;i++){
                int temp=grid[i][l];
                grid[i][l]=grid[i][r];
                grid[i][r]=temp;
            }
            l++;
            r--;
        }
    }
}
