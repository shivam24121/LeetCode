class Solution {
    public int binaryGap(int n) {

        if(Integer.bitCount(n)<=1){
            return 0;
        }
        String s=Integer.toBinaryString(n);
        int res=0;
        int ct=0;
        int i=0;
        int prev=-1;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                if(prev!=-1){
                    res=Math.max(res,i-prev);
                }
                prev=i;
            }
            i++;
        }
        return res;
    }
}
