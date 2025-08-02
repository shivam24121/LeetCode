class Solution {
    public int[] countBits(int n) {
        int[] l=new int[n+1];
        for(int i=0;i<=n;i++){
            l[i]=Integer.bitCount(i);    
        }
        return l;
    }
}
