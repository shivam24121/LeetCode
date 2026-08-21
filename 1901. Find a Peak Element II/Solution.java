class Solution {

    public int solve(int[][] arr,int mid,int n){

        int res=-1;
        int val=-1;

        for(int i=0;i<n;i++){
            if(arr[i][mid]>val){
                val=arr[i][mid];
                res=i;
            }
        }
        return res;
    }
    public int[] findPeakGrid(int[][] mat) {
        
        int n=mat.length;
        int m=mat[0].length;

        int l=0;
        int r=m-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            int maxIdx=solve(mat,mid,n);

            int left=(mid-1>=0)?mat[maxIdx][mid-1]:-1;
            int right=(mid+1<m)?mat[maxIdx][mid+1]:-1;

            if(mat[maxIdx][mid]>left && mat[maxIdx][mid]>right){
                return new int[]{maxIdx,mid};
            }
            else if(left>mat[maxIdx][mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return new int[]{-1,-1};
    }
}
