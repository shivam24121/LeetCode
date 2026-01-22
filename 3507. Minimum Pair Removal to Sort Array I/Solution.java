class Solution {

    public boolean sorted(ArrayList<Integer>res){
        for(int i=0;i<res.size()-1;i++){
            if(res.get(i)>res.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public int idx(ArrayList<Integer>res){
        int sum=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<res.size()-1;i++){
            int curr=res.get(i)+res.get(i+1);
            if(curr<sum){
                sum=curr;
                idx=i;
            }
        }
        return idx;
    }
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer>res=new ArrayList<>();
        for(int i:nums){
            res.add(i);
        }

        int ct=0;

        while(!sorted(res)){
            int idx=idx(res);
            int sum=res.get(idx)+res.get(idx+1);
            res.set(idx,sum);
            res.remove(idx+1);
            ct++;
        }
        return ct;
    }
}
