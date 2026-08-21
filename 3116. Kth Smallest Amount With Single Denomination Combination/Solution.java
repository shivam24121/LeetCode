class Solution {

    int n;

    public long findKthSmallest(int[] arr, int k) {
        
        n=arr.length;

        long l=Integer.MAX_VALUE;
        long r=Integer.MIN_VALUE;

        for(int i:arr){
            l=Math.min(l,i);
            r=Math.max(r,i);
        }
        long ans=-1;
        r*=k;

        while(l<=r){
            long mid=l+(r-l)/2;
            if(solve(arr,mid)>=k){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public long solve(int[] arr,long mid){

        long count=0;

        for(int mask=1;mask<=(1<<n)-1;mask++){

            long lcm=0;
            long setBit=0;

            for(int i=0;i<n;i++){

                if((mask&(1<<i))!=0){
                    setBit++;

                    if(lcm==0){
                        lcm=arr[i]*1L;
                    }
                    else{
                        lcm=(lcm*arr[i])/gcd(lcm,arr[i]);
                    }
                }
            }
            
            // count+=(setBit%2==0)?-lcm:lcm;

            if(setBit%2==0){
                count-=(mid/lcm);
            }
            else{
                count+=(mid/lcm);
            }
            System.out.println(count);
        }
        return count;
    }
    public long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}
