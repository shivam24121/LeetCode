class Solution {
    public int findClosest(int x, int y, int z) {
        int xzDistance=Math.abs(z-x);
        int yzDistance=Math.abs(z-y);

        if(xzDistance==yzDistance)return 0;
        else if(xzDistance<yzDistance)return 1;
        else return 2;
    }
}
