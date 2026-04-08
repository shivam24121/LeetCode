class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        int mod=(int)1e9+7;
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            a[i]=nums[i];
        }
        for(int i=0;i<m;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            long v=(long)queries[i][3];
            for(int j=l;j<=r;j+=k){
               a[j]=(a[j]*v)%mod;
            }
        }
        long ct=0;
        for(int i=0;i<n;i++){
            ct^=a[i];
        }
        return (int)(ct);
    }
}
