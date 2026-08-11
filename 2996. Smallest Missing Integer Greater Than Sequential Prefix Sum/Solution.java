class Solution {
    public int missingInteger(int[] nums) {
        
        int n=nums.length;
        Set<Integer>set=new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        int sum=nums[0];

        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }
            else{
                break;
            }
        }
        while(true){
            if(set.contains(sum)==false){
                break;
            }
            sum++;
        }
        return sum;
    }
}
