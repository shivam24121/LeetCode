class Solution {
    public int scoreDifference(int[] nums) {
        
        int n=nums.length;
        boolean fl=true;
        long a=0,b=0;

        for(int i=1;i<=n;i++){
            if(odd(nums[i-1])){
                fl=!fl;
            }
            if(i%6==0){
                fl=!fl;
            }
            if(fl){
                a+=nums[i-1];
            }
            else{
                b+=nums[i-1];
            }
        }
        return (int)(a-b);
    }
    public boolean odd(int a){
        return (a&1)==1;
    }
}
