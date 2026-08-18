class Solution {
    public int largestInteger(int[] nums, int k) {

        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int largest=-1;
        if(k==1){
            for(int i:nums){
                if(map.get(i)==1){
                    largest=Math.max(largest,i);
                }
            }
            return largest;
        }
        else if(k==n){
            for(int i:nums){
                largest=Math.max(largest,i);
            }
            return largest;
        }
        else{
            int st=nums[0];
            int end=nums[n-1];

            int ans1=-1;
            int ans2=-1;

            if(map.get(st)==1){
                ans1=st;
            }
            if(map.get(end)==1){
                ans2=end;
            }
            return Math.max(ans1,ans2);
        }
    }
}
