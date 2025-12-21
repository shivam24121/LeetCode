class Solution {
    public long lastInteger(long n) {
        long last=1,gap=1,rem=n;
        boolean left=true;

        while(rem>1){
            if(!left && rem%2==0){
                last=last+gap;
            }
            left=!left;
            rem=(rem+1)/2;
            gap=gap*2;
        }
        return last;
    }
}
