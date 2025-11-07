class Solution {
    int n;

    public long maxPower(int[] stations, int r, int k) {
        n=stations.length;

        long[] diff=new long[n];

        for(int i=0;i<n;i++){
            diff[Math.max(0,i-r)]+=stations[i];
            if(i+r+1<n){
                diff[i+r+1]-=stations[i];
            }
        }

        long l=Arrays.stream(stations).min().getAsInt();
        long right=Arrays.stream(stations).asLongStream().sum()+k;
        long res=0;

        while(l<=right){
            long mid=l+(right-l)/2;
            if(solve(mid,diff,r,k)){
                res=mid;
                l=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return res;
    }
    public boolean solve(long mid,long[] diff,int r,int k){
        long[] tempDiff=Arrays.copyOf(diff,n);
        long currSum=0;

        for(int i=0;i<n;i++){
            currSum+=tempDiff[i];
            
            if(currSum<mid){
                long req=mid-currSum;
                if(req>k){
                    return false;
                }
                currSum+=req;
                k-=req;

                if((i+2*r+1)<n){
                    tempDiff[i+2*r+1]-=req;
                }
            }
        }
        return true;
    }
}
