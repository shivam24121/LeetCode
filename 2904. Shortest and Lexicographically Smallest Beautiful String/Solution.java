class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int n=s.length();
        int l=0;

        String res="";
        int one=0;

        for(int r=0;r<n;r++){

            if(s.charAt(r)=='1'){
                one++;
            }
            while(one>k || (l<n && s.charAt(l)=='0')){
                if(s.charAt(l)=='1'){
                    one--;
                }
                l++;
            }
            if(one==k){
                if(res.equals("") || res.length()>r-l+1 || (res.length()==r-l+1 && res.compareTo(s.substring(l,r+1))>=1)){
                    res=s.substring(l,r+1);
                }
            }
        }
        return res;
    }
}
