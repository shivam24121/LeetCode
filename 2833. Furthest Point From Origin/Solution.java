class Solution {
    public int furthestDistanceFromOrigin(String s) {
        
        int n=s.length();
        int pos=0;

        int dot=0;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='L'){
                pos--;
            }
            else if(c=='R'){
                pos++;
            }
            else{
                dot++;
            }
        }
        return pos<0?Math.abs(pos-dot):pos+dot;
    }
}
