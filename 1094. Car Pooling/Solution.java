class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        int[] res=new int[1002];

        for(int[] e:trips){
            int cap=e[0];
            int l=e[1];
            int r=e[2];

            res[l]+=cap;
            res[r]-=cap;
        }
        int prefix=0;
        for(int i=0;i<res.length;i++){
            prefix+=res[i];
            if(prefix>capacity){
                return false;
            }
        }
        return true;
    }
}
