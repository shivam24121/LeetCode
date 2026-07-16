class Solution {
    public long gcdSum(int[] nums) {
        
        int n=nums.length;
        int[] prefix=new int[n];
        int max=nums[0];
        prefix[0]=max;
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            prefix[i]=gcd(max,nums[i]);
        }
        Arrays.sort(prefix);
        long res=0;
        int l=0,r=n-1;

        while(l<r){
            int temp=gcd(prefix[l],prefix[r]);
            res+=temp;
            l++;
            r--;
        }
        return res;
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
