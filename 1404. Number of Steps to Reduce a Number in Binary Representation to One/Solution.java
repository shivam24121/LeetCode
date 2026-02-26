class Solution {
    public int numSteps(String s) {
        int ct=0;
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>1){
            if((sb.charAt(sb.length()-1)-'0')%2==1){
                solve(sb);
                ct++;
            }
            else{
                ct++;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return ct;
    }
    public void solve(StringBuilder sb){
        int i=sb.length()-1;
        while(i>=0 && sb.charAt(i)=='1'){
            sb.setCharAt(i,'0');
            i--;
        }
        if(i>=0){
            sb.setCharAt(i,'1');
        }
        else{
            sb.insert(0,'1');
        }
    }
}



