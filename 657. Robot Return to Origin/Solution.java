class Solution {
    public boolean judgeCircle(String s) {
        
        int n=s.length();

        int x=0,y=0;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(c=='L'){
                y--;
            }
            else if(c=='R'){
                y++;
            }
            else if(c=='U'){
                x--;
            }
            else{
                x++;
            }
        }
        return x==0 && y==0;
    }
}
