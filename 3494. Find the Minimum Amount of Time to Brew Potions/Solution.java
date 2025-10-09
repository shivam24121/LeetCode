class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n=skill.length;
        int m=mana.length;

        long[] res=new long[n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j+1]=Math.max(res[j+1],res[j])+(long)mana[i]*skill[j];
            }
            for(int j=n-1;j>0;j--){
                res[j]=res[j+1]-(long) mana[i]*skill[j];
            }
        }
        return res[n];
    }
}
