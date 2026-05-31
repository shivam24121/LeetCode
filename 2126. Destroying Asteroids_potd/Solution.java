class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        
        int n=arr.length;

        Arrays.sort(arr);

        long sum=mass;

        for(int i=0;i<n;i++){
            if(sum<arr[i]){
                return false;
            }
            sum+=arr[i];
        }
        return true;
    }
}
