class Solution {

    public int minFlips(String s) {

        int n=s.length();
        int res=Integer.MAX_VALUE;
        int ct0=0,ct1=0;
        int l=0;

        for(int r=0;r<2*s.length();r++){

            int curr=s.charAt(r%n)-'0';
            int exp0=(r%2)==1?0:1;
            int exp1=(r%2)==1?1:0;

            if(curr!=exp0)ct0++;
            if(curr!=exp1)ct1++;

            while((r-l+1)>n){
                int winCurr=s.charAt(l%n)-'0';
                int winExp0=(l%2)==1?0:1;
                int winExp1=(l%2)==1?1:0;

                if(winCurr!=winExp0)ct0--;
                if(winCurr!=winExp1)ct1--;

                l++;
            }

            if(r-l+1==s.length()){
                res=Math.min(Math.min(ct0,ct1),res);
            }
        }
        return res;
    }
}
