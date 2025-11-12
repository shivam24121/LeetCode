class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ctOne=0;

        for(int i:nums){
            if(i==1)ctOne++;
        }

        if(ctOne>0)return n-ctOne;

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int curr=nums[i];
            for(int j=i+1;j<n;j++){
                curr=gcd(curr,nums[j]);
                if(curr==1){
                    min=Math.min(min,j-i);
                }
            }
        }
        if(min==Integer.MAX_VALUE)return -1;
        return (n-1)+min;
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
