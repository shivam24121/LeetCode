class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int curr=0;

        for(int i:gain){
            max=Math.max(max,curr+i);
            curr=curr+i;
        }
        return max;
    }
}
