class Solution {
    public int numberOfBeams(String[] bank) {
        int res=0;
        int prev=0;

        int n=bank.length;
        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=0;j<bank[i].length();j++){
                char c=bank[i].charAt(j);
                if(c=='1')curr++;
            }
            res+=curr*prev;
            if(curr!=0)prev=curr;
        }return res;
    }
}
