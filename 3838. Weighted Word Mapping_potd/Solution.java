class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder sb=new StringBuilder();

        for(String s:words){
            int n=s.length();
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=weights[s.charAt(i)-'a'];
            }
            sum%=26;
            int tempIdx=26-sum;
            sb.append((char)('a'+tempIdx-1));
        }
        return sb.toString();
    }
}
