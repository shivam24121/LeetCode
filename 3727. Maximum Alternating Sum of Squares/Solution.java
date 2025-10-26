class Solution {
    public long maxAlternatingSum(int[] nums) {
        // sq will give abs;

        int n=nums.length;
        long sum=0;
        int mid=n/2;

        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Math.abs(nums[i]);
        }
        Arrays.sort(a);

        for(int i=0;i<n;i++){
            if(i<mid){
                sum-=((long)a[i]*a[i]);
            }
            else{
                sum+=((long)a[i]*a[i]);
            }
        }
        return sum;
    }
}
