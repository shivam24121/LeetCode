class Solution {
    public boolean isGood(int[] nums) {

        if(nums.length==1){
            return false;
        }

        int[] freq=new int[nums.length+1];

        for(int i:nums){
            if(i>nums.length)continue;
            freq[i]++;
        }
        // for(int i=0;i<=nums.length;i++){
        //     System.out.print(freq[i]+" ");
        // }
        // System.out.println();

        for(int i=1;i<nums.length-1;i++){
            if(freq[i]==0){
                // System.out.println(i+" leagya");
                return false;
            }
            // System.out.println(i+" ding dong");
        }
        return freq[nums.length-1]==2;
    }
}
