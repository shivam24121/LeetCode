class Solution {
    public int minimumMoves(String s) {
        int res=0;
        char[] c=s.toCharArray();
        int n=c.length;
        for(int i=0;i<s.length()-2;i++){
            if(c[i]=='X'){
                c[i+1]='0';
                c[i+2]='0';
                res++;
            }
        }
        if(c[n-1]=='X'|| c[n-2]=='X')res++;
        return res;
    }
}
