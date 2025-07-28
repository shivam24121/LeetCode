class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        int maxor=0;
        int count=0;
        for(int i=0;i<n;i++){
            maxor|=nums[i];
        }
        int sub=1<<n;
        for(int i=0;i<sub;i++){
            int curor=0;
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    curor|=nums[j];
                }
            }
            if(curor==maxor){
                count++;
            }
        }
        return count;
    }
}
