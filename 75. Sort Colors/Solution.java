class Solution {
    public void sortColors(int[] nums) {

        int i=0,j=0,k=nums.length-1;
        while(j<=k){
            if(nums[j]==2){
                swap(nums,j,k);
                k--;
            }
            else if(nums[j]==0){
                swap(nums,j,i);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
    }
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
