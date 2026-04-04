class Solution {
    public String decodeCiphertext(String s, int rows) {
        
        StringBuilder sb=new StringBuilder();

        int n=s.length();
        int col=n/rows;

        for(int i=0;i<col;i++){
            for(int j=i;j<n;j+=(col+1)){
                sb.append(s.charAt(j));
            }
        }
        while(sb.length()>=1 && sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
