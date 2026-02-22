class Solution {
    public String maximumXor(String s, String t) {

        int n=s.length();

        int ct0=0,ct1=0;

        for(int i=0;i<n;i++){
            if(t.charAt(i)=='0')ct0++;
            else ct1++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            
            if(c=='1'){
                if(ct0>0){
                    sb.append('1');
                    ct0--;
                }
                else{
                    sb.append('0');
                    ct1--;
                }
            }
            else{
                if(ct1>0){
                    sb.append('1');
                    ct1--;
                }
                else{
                    sb.append('0');
                    ct0--;
                }
            }
        }
        return sb.toString();
    }
}
