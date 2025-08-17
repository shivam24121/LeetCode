class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] a=new int[n+1];
        Arrays.fill(a,0);
        for(int i=0;i<n;i++){
            int x=citations[i];
            if(x>n){
                a[n]++;
            }
            else{
                a[x]++;
            }
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=a[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;
    }
}
