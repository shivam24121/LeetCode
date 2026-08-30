class Solution {
    public int minimumDeletions(int[] arr) {
        
        int n=arr.length;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        int maxIdx=-1;
        int minIdx=-1;

        for(int i=0;i<n;i++){

            if(arr[i]<min){
                min=arr[i];
                minIdx=i;
            }
            if(max<arr[i]){
                max=arr[i];
                maxIdx=i;
            }
        }
        int l=Math.min(minIdx,maxIdx);
        int r=Math.max(minIdx,maxIdx);

        return Math.min(r+1,Math.min(n-l,l+1+n-r));
    }
}
