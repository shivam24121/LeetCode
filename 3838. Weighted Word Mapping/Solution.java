class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        int n=words.length;

        for(int i=0;i<n;i++){
            String curr=words[i];
            int sum=0;
            for(int j=0;j<curr.length();j++){
                sum+=weights[curr.charAt(j)-'a'];
            }
            sum=sum%26;
            sb.append((char)('z'-sum));
        }
        return sb.toString();
    }
}
