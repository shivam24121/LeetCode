class Solution {
    public int maxChunksToSorted(int[] arr) {
        int curr=0,res=0;
        for(int i=0;i<arr.length;i++){
            curr+=arr[i]-i;
            if(curr==0)res++;
        }
        return res;
    }
}
