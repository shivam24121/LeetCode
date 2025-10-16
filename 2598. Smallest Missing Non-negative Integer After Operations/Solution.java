class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            int r=((i%value)+value)%value;
            map.put(r,map.getOrDefault(r,0)+1);
        }
        int mex=0;
        while(map.getOrDefault(mex%value,0)>0){
            map.put(mex%value,map.getOrDefault(mex%value,0)-1);
            mex++;
        }
        return mex;
    }
}
