class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<=3)return false;

        boolean p=false,q=false;

        int i=0;
        int i1=0;
        while(i+1<n && nums[i]<nums[i+1]){
            i++;
            i1++;
        }
        if(i1==0)return false;
        p=true;

        int d1=0;
        while(i+1<n && nums[i]>nums[i+1]){
            i++;
            d1++;
        }
        if(d1==0)return false;
        q=true;

        int i2=0;
        while(i+1<n && nums[i]<nums[i+1]){
            i++;
            i2++;
        }
        if(i2==0){
            return false;
        }

        return i==n-1 && p && q;
    }
}
