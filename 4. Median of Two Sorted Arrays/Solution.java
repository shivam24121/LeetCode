class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int n=nums1.length;
        int m=nums2.length;

        int total=(n+m);
        int half=(total+1)/2;

        int l=0;
        int r=n;

        while(l<=r){

            int mid=l+(r-l)/2;

            int secondPick=half-mid;

            int ax=mid==0?Integer.MIN_VALUE:nums1[mid-1];
            int ay=mid==n?Integer.MAX_VALUE:nums1[mid];
            int bx=secondPick==0?Integer.MIN_VALUE:nums2[secondPick-1];
            int by=secondPick==m?Integer.MAX_VALUE:nums2[secondPick];

            if(ax<=by && bx<=ay){
                if(total%2==1){
                    return Math.max(ax,bx);
                }
                else{
                    return ((double)Math.max(ax,bx)+(double)Math.min(ay,by))/2.0;
                }
            }
            else if(ax>by){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return 0.0;
    }
}
