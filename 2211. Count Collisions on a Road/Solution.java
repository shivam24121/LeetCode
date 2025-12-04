class Solution {
    public int countCollisions(String dir) {
        int ct=0;
        int n=dir.length();

        int l=0,r=n-1;
        while(l<n && dir.charAt(l)=='L'){
            l++;
        }
        while(r>=0 && dir.charAt(r)=='R'){
            r--;
        }

        for(int i=l;i<=r;i++){
            if(dir.charAt(i)!='S'){
                ct++;
            }
        }
        return ct;
    }
}
