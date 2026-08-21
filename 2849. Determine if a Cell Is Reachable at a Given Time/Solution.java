class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        int time=0;

        if(sx==fx && sy==fy && t==1){
            return false;
        }

        int dx=Math.abs(sx-fx);
        int dy=Math.abs(sy-fy);

        time=Math.max(dx,dy);

        if(time>t){
            return false;
        }
        return true;
    }
}
