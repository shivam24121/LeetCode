class Solution {
    public long removeZeros(long n) {
        String s=Long.toString(n);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='0')continue;
            sb.append(c);
        }
        return sb.length()==0?0:Long.parseLong(sb.toString());
    }
}
