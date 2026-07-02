class Solution {
    public int maxScore(int[] arr, int k) {

        int n=arr.length;
        int sum=0;
        
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int res=sum;
        int l=k-1;
        int r=n-1;

        for(int i=0;i<k;i++){
            sum+=arr[r--];
            sum-=arr[l--];
            res=Math.max(res,sum);
        }
        return res;
    }
}
