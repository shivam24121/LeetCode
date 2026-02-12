class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int res=1;

        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;

                if(valid(freq)){
                    res=Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
    public boolean valid(int[] freq){
        int temp=0;

        for(int i=0;i<26;i++){
            if(freq[i]==0)continue;
            if(temp==0)temp=freq[i];
            if(temp!=freq[i])return false;
        }
        return true;
    }
}
