class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Arrays.stream(piles).max().getAsInt();
        int l=0,r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(solve(piles,mid)<=h){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int solve(int[]nums,int mid){
        int res=0;
        for(int i=0;i<nums.length;i++){
            res+=Math.ceil((double)nums[i]/mid);
        }
        return res;
    }
}
