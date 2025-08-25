class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        String[] res=new String[numRows];
        for(int i=0;i<numRows;i++){
            res[i]="";
        }
        int i=0;
        while(i<n){
            for(int j=0;j<numRows && i<n;j++){
                res[j]+=s.charAt(i++);
            }
            for(int j=numRows-2;j>0 && i<n;j--){
                res[j]+=s.charAt(i++);
            }
        }
        String ans="";
        for(String sb:res){
            ans+=sb;
        }
        return ans;
    }
}
