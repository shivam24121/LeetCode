class Solution {
    public int maxDistance(int[] arr) {
        
        int res=0;
        int n=arr.length;

        for(int i=0;i<n;i++){

            if(arr[i]!=arr[n-1]){
                res=Math.max(res,(n-1)-i);
            }
            if(arr[i]!=arr[0]){
                res=Math.max(res,i);
            }
        }
        return res;
    }
}
