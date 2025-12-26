class Solution {
    public int bestClosingTime(String s) {
        int n=s.length();
        int pen=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='Y'){
                pen++;
            }
        }
        int res=pen,best=0;

        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)=='Y'){
                pen--;
            }
            else{
                pen++;
            }
            //System.out.print(pen+" ");
            if(pen<res){
                res=pen;
                best=i;
            }
        }
        return best;
    }
}
