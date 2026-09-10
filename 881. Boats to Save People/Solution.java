class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        
        int n=arr.length;
        Arrays.sort(arr);

        int l=0;
        int r=n-1;

        int res=0;

        while(l<=r){

            int sum=arr[l]+arr[r];
            if(sum>limit){

                res++;
                r--;
            }
            else{
                res++;
                l++;
                r--;
            }
        }
        return res;
    }
}
