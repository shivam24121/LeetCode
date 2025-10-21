class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n=nums.length;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }

        int[] freq=new int[max+1];
        for(int i:nums){
            freq[i]++;
        }

        for(int i=1;i<=max;i++){
            freq[i]+=freq[i-1];
        }
        int res=0;

        for(int i=min;i<=max;i++){
            int l=Math.max(min,i-k);
            int r=Math.min(max,i+k);

            int currFreq=freq[i]-freq[i-1];
            int extra=Math.min(numOperations,freq[r]-freq[l-1]-currFreq);

            res=Math.max(res,currFreq+extra);
        }
        return res;
    }
}
