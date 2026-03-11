class Solution {
    public int bitwiseComplement(int n) {
        String s=Integer.toBinaryString(n);
        int res=0;
        int len=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                res|=(1<<(len-i-1));
            }
        }
        return res;
    }
}
