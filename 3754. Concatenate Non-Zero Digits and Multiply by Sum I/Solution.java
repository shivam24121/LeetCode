class Solution {
    public long sumAndMultiply(int n) {
        long res=0;
        int sum=0;
        StringBuilder sb=new StringBuilder();

        if(n==0){
            return 0;
        }

        String s=String.valueOf(n);

        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'0';
            if(idx!=0){
                sb.append(idx);
                sum+=idx;
            }
        }
        res=1L*Integer.parseInt(sb.toString())*sum;
        return res;
    }
}
