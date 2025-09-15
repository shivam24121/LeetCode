class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Arrays.stream(nums).max().getAsInt();
        int l=0,h=max;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(solve(nums,mid)<=threshold){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int solve(int[]a,int mid){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=Math.ceil((double)a[i]/mid);
        }
        return sum;
    }
}
