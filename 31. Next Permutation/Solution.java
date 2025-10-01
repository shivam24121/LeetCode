class Solution {
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public void reverse(int[] a,int i,int j){
        while(i<j){
            swap(a,i,j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int gola=-1,bada=-1;
        int n=nums.length;
        
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                gola=i-1;
                break;
            }
        }
        if(gola!=-1){
            for(int i=n-1;i<=gola+1;i--){
                if(nums[i]>nums[gola]){
                    bada=i;
                    break;
                }
            }
            swap(nums,gola,bada);
        }
        reverse(nums,gola+1,n-1);
    }
}
