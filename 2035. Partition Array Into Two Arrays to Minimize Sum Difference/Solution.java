class Solution {
    public int minimumDifference(int[] nums) {
        
        int n=nums.length;
        int half=n/2;
        int res=Integer.MAX_VALUE;

        int sum=0;
        for(int i:nums){
            sum+=i;
        }

        int[] a=new int[half];
        int[] b=new int[half];

        for(int i=0;i<n/2;i++){
            a[i]=nums[i];
            b[i]=nums[i+half];
        }

        Map<Integer,ArrayList<Integer>>map=new HashMap<>();

        for(int mask=0;mask<(1<<(half));mask++){
            int temp=0;
        
            for(int i=0;i<n/2;i++){
                if(((mask)&(1<<i))!=0){
                    temp+=a[i];
                }
            }
            int ct=Integer.bitCount(mask);
            map.putIfAbsent(ct,new ArrayList<>());
            map.get(ct).add(temp);
        }
        for(ArrayList<Integer>list:map.values()){
            Collections.sort(list);
        }

        for(int mask=0;mask<(1<<half);mask++){
           
            int temp=0;
            for(int i=(0);i<half;i++){
                if(((mask)&(1<<i))!=0){
                    temp+=b[i];
                   
                }
            }
            int ct=Integer.bitCount(mask);
            List<Integer>list=map.get(half-ct);
            
            int target=(sum/2-temp);
            int idx=Collections.binarySearch(list,target);

            if(idx<0){
                idx=-(idx+1);
            }
            if(idx<list.size()){
                res=Math.min(res,Math.abs(sum-2*(temp+list.get(idx))));
            }
            if(idx>0){
                res=Math.min(res,Math.abs(sum-2*(temp+list.get(idx-1))));
            }
        }
        return res;
    }
}
