class Solution {
    public int minimumDistance(int[] nums) {

        int n=nums.length;

        Map<Integer,ArrayList<Integer>>map=new HashMap<>();

        for(int i=0;i<n;i++){

            int curr=nums[i];
            map.putIfAbsent(curr,new ArrayList<>());
            map.get(curr).add(i);
        }

        int res=Integer.MAX_VALUE;

        for(var e:map.entrySet()){

            ArrayList<Integer>list=e.getValue();

            if(list.size()<=2){
                continue;
            }
            int temp=(list.get(2)-list.get(0))+(list.get(1)-list.get(0))+(list.get(2)-list.get(1));

            for(int i=3;i<list.size();i++){
                temp=Math.min(temp,(list.get(i)-list.get(i-2))+
                                   (list.get(i)-list.get(i-1))+
                                   (list.get(i-1)-list.get(i-2)));
            }
            res=Math.min(res,temp);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
