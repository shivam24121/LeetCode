class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] t=new long[n+1];
        Arrays.fill(t,Long.MAX_VALUE);
        t[0]=0;
        for(int i=1;i<=n;i++){
            long temp=costs[i-1];
            if(i-1>=0){
                long jump=temp+1;
                t[i]=Math.min(t[i],t[i-1]+jump);
            }
            if(i-2>=0){
                long jump=temp+4;
                t[i]=Math.min(t[i],t[i-2]+jump);
            }
            if(i-3>=0){
                long jump=temp+9;
                t[i]=Math.min(t[i],t[i-3]+jump);
            }
        }
        return (int)t[n];
    }
}
