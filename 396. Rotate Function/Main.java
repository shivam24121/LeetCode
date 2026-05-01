class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n=nums.length;
        int rem=n-1;
        
        int sum=0;
        long res=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            res+=(long)i*(nums[i]);
        }
        long prev=res;

        for(int i=0;i<n;i++){
            // System.out.print("before "+res+" after ");
            long temp=prev;
            temp+=(sum-nums[rem]);
            temp-=((long)(n-1)*nums[rem--]);
            // System.out.println(res+" temp "+temp);
            res=Math.max(res,temp);
            prev=temp;
        }
        return (int)res;
    }
}
