class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int[] zero=new int[n];
        for(int i=0;i<n;i++){
            int ct=0;
            int j=n-1;
            while(j>=0 && grid[i][j]==0){
                ct++;
                j--;
            }
            zero[i]=ct;
        }
        int res=0;
        for(int i=0;i<n;i++){
            int need=n-i-1;
            int j=i;
            while(j<n && zero[j]<need){
                j++;
            }
            if(j==n)return -1;

            res+=(j-i);

            while(i<j){
                int temp=zero[j];
                zero[j]=zero[j-1];
                zero[j-1]=temp;
                j--;
            }
        }
        return res;
    }
}
