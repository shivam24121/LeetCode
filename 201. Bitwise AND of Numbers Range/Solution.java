class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        int res=0;

        for(int i=31;i>=0;i--){
            int mask=(1<<i);
            if((mask&left) != (mask&right)){
                return res;
            }
            if((mask&left)!=0){
                res|=mask;
            }
        }
        return res;
    }
}


