class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int len=batteries.length;
        long sum=0;
        for(int i:batteries){
            sum+=i;
        }

        long l=0,r=sum/n;
        long res=0;

        while(l<=r){
            long mid=l+(r-l)/2;
            if(valid(batteries,mid,n)){
                res=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    public boolean valid(int[] nums,long mid,int n){
        long sum=0;
        for(int i:nums){
            sum+=Math.min(mid,i);
        }
        return sum>=(n*mid);
    }
}
