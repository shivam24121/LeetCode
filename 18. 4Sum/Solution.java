class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        long t=(long)target;
        for(int a=0;a<n-3;a++){
            if(a>0 && nums[a]==nums[a-1])continue;
            long min=(long)nums[a]+nums[a+1]+nums[a+2]+nums[a+3];
            if(min>t)break;
            long max=(long)nums[a]+nums[n-1]+nums[n-2]+nums[n-3];
            if(max<t)continue;
            for(int b=a+1;b<n-2;b++){
                if(b>a+1 && nums[b]==nums[b-1])continue;
                long temp=target-(nums[a]+nums[b]);
                int i=b+1,j=n-1;
                while(i<j){
                    long sum=nums[i]+nums[j];
                    if(sum==temp){
                        List<Integer>cur=new ArrayList<>();
                        cur.add(nums[a]);
                        cur.add(nums[b]);
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        res.add(cur);
                        i++;
                        j--;
                        while(i<j && nums[i]==nums[i-1])i++;
                        while(i<j && nums[j]==nums[j+1])j--;
                    }
                    else if(sum<temp){
                        i++;
                    }
                    else{
                        j--;
                    }
                }
            }
        }
        return res;
    }
}
