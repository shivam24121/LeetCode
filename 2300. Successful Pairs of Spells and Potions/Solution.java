class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int[] res=new int[n];

        Arrays.sort(potions);

        for(int i=0;i<n;i++){
            long need=(success+spells[i]-1)/spells[i];
            int idx=bs(potions,need);
            res[i]=m-idx;
        }
        return res;
    }
    public int bs(int[] nums,long target){
        int l=0,r=nums.length-1;
        int res=nums.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>=target){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
}
