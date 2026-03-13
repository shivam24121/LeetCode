class Solution {
    public long minNumberOfSeconds(int k, int[] arr) {
        int n=arr.length;
        long res=-1;
        long r=Long.MIN_VALUE;
        long l=1;
        for(int i:arr){
            r=Math.max(r,i);
        }
        r=r*k*(k+1)/2;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(valid(mid,k,arr)){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    public boolean valid(long mid,int k,int[] arr){
        long ct=0;
        for(int i=0;i<arr.length;i++){
            ct+=Math.sqrt(mid*2.0/arr[i]+0.25)-0.5;
        }
        return ct>=k;
    }
}
