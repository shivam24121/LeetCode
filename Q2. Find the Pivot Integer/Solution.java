class Solution {
    public int pivotInteger(int n) {
        if(n==1)return 1;
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=i;
        }
        int[] prefix=new int[n+1];
        prefix[0]=0;
        prefix[1]=a[1];
        for(int i=2;i<=n;i++){
            prefix[i]=prefix[i-1]+a[i];
        }

        for(int i=1;i<n;i++){
            int less=prefix[i-1];
            int more=prefix[n]-prefix[i];
            if(less==more){
                return i;
            }
        }
        return -1;
    }
}
