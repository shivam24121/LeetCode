class Solution {
    public double angleClock(int hour, int minutes) {
        double angle=Math.abs((1.0*hour*30.0)-(5.5*minutes));
        return Math.min(angle,360-angle);
    }
}
