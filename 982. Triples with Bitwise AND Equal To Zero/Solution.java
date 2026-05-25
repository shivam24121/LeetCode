class Solution {
    public int countTriplets(int[] nums) {
        
        int n=nums.length;

        int[] count=new int[1<<16];

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                
                int and=nums[i] & nums[j];

                count[and]++;
            }
        }
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<count.length;j++){
                
                ans+=((nums[i] & j)==0)?count[j]:0;
            }
        }
        return ans;
    }
}
