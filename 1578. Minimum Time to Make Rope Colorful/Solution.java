class Solution {
    public int minCost(String s, int[] neededTime) {
        int res=0;
        int n=s.length();

        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                res+=Math.min(neededTime[i],neededTime[i-1]);
                neededTime[i]=Math.max(neededTime[i],neededTime[i-1]);
            }
        }
        return res;
    }
}
