class Solution {
    public int jump(int[] nums) {
        int steps=0;
        int n=nums.length;
        int l=0,r=0;
        while(r<n-1){
            int far=0;
            for(int i=l;i<=r;i++){
                far=Math.max(far,i+nums[i]);
            }
            l=r+1;
            r=far;
            steps++;
        }
        return steps;
    }
}
