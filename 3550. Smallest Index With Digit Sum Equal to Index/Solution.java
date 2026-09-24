class Solution {
    public int smallestIndex(int[] nums) {
        
        int n=nums.length;

        int res=-1;

        for(int i=0;i<n;i++){
            if(i==sum(nums[i])){
                if(res==-1){
                    res=i;
                }
            }
        }
        return res;
    }
    public int sum(int n){
        int val=0;
        String s=String.valueOf(n);

        for(char c:s.toCharArray()){
            val+=c-'0';
        }
        return val;
    }
}
