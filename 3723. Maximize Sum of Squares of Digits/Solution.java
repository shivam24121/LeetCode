class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if((long)sum>9*num){
            return "";
        }
        StringBuilder sb=new StringBuilder();

        int full=sum/9;
        int rem=sum%9;

        for(int i=0;i<full && sb.length()<num;i++){
            sb.append('9');
        }
        if(rem>0 && sb.length()<num){
            sb.append((char)(rem+'0'));
        }
        while(sb.length()<num){
            sb.append('0');
        }
        return sb.toString();
    }
}
