class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s=new StringBuilder();
        s.append('0');
        //System.out.println(s.toString());
        return solve(n,s,1,k-1);
    }
    public char solve(int n,StringBuilder s,int idx,int k){
        if(idx==n){
            return s.charAt(k);
        }
        //System.out.print(s.toString()+" after ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        //System.out.print(sb.toString()+" ");
        s.append('1').append(sb.reverse().toString());
        //System.out.println("ops "+s.toString());
        return solve(n,s,idx+1,k);
    }
}
