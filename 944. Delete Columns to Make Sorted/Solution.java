class Solution {
    public int minDeletionSize(String[] strs) {
        int m=strs[0].length();
        int n=strs.length;
        int res=0;

        for(int i=0;i<m;i++){
            char temp='a';
            for(int j=0;j<n;j++){
                char curr=strs[j].charAt(i);
                if(curr>=temp){
                    temp=curr;
                }
                else{
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
