class Solution {
    public int minBitFlips(int start, int goal) {
        int res=0;
        String s1=Integer.toBinaryString(start);
        String s2 =Integer.toBinaryString(goal);

        int a=s1.length();
        int b=s2.length();
        int max=Math.max(a,b);

        while(s1.length()<max){
            s1='0'+s1;
        }
        while(s2.length()<max){
            s2='0'+s2;
        }
        for(int i=0;i<max;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                res++;
            }
        }
        return res;
    }
}
