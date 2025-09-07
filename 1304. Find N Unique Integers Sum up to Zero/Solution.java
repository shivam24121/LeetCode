class Solution {
    public int[] sumZero(int n) {
        if(n==0)return new int[]{0};
        int[] a=new int[n];
        if((n&1)==1){
            int idx=0;
            for(int i=-n/2;i<=n/2;i++){
                a[idx++]=i;
            }
        }
        else{
            int idx=0;
            for(int i=-n/2;i<=n/2;i++){
                if(i==0)continue;
                a[idx++]=i;
            }
        }
        return a;
    }
}
