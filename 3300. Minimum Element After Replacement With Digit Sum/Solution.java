class Solution {
    public int minElement(int[] nums) {
        
        int ans=Integer.MAX_VALUE;

        for(int i:nums){
            ans=Math.min(ans,sum(i));
        }
        return ans;
    }
    public int sum(int n){
        
        int res=0;
        while(n>0){
            int a=n%10;
            res+=a;
            n/=10;
        }
        return res;
    }
}
