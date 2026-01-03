class Solution {
    public int findMaxVal(int n, int[][] r, int[] diff) {
        int[] res=new int[n];
        int inf=Integer.MAX_VALUE;
        Arrays.fill(res,Integer.MAX_VALUE);
        res[0]=0;

        for(int[] e:r){
            int u=e[0];
            int v=e[1];
            res[u]=Math.min(res[u],v);
        }
        for(int i=0;i<n-1;i++){
            if(res[i]!=inf){
                res[i+1]=Math.min(res[i+1],res[i]+diff[i]);
            }
        }
        for(int i=n-2;i>=0;i--){
            if(res[i+1]!=inf){
                res[i]=Math.min(res[i],res[i+1]+diff[i]);
            }
        }
        int min=Integer.MIN_VALUE;
        for(int i:res){
            min=Math.max(i,min);
        }
        return min;
    }
}©leetcode
