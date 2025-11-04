class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int size=n-k+1;
        int[] res=new int[size];

        for(int i=0;i<size;i++){
            res[i]=solve(i,i+k-1,nums,x);
        }
        return res;
    }
    public int solve(int st,int end,int[] nums,int top){
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=st;i<=end;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)->{
            int aa=a.getValue();
            int bb=b.getValue();
            if(aa==bb){
                return b.getKey()-a.getKey();
            }
            else{
                return bb-aa;
            }
        });
        pq.addAll(map.entrySet());

        int sum=0;
        while(!pq.isEmpty() && top>0){
            Map.Entry<Integer,Integer>entry=pq.poll();
            int key=entry.getKey();
            int val=entry.getValue();
            sum+=key*val;
            top--;
        }
        return sum;
    }
}
