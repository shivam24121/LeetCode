class Solution {
    public boolean scoreBalance(String s) {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            sum+=c-'a'+1;
        }
        int curr=0;
        for(int i=0;i<n-1;i++){
            curr+=s.charAt(i)-'a'+1;
            if(curr*2==sum)return true;
        }
        return false;
    }
}
