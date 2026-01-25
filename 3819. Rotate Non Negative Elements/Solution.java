class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n=nums.length;
        int idx=0;

        ArrayList<Integer>val=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                val.add(nums[i]);
                nums[i]=100005;
            }
        }
        int m=val.size();
        if(m==0)return nums;

        k%=val.size();

        rev(val,0,k-1);
        rev(val,k,m-1);
        rev(val,0,m-1);

        for(int i=0;i<n;i++){
            if(nums[i]==100005){
                nums[i]=val.get(idx++);
            }
        }
        return nums;
    }
    public void rev(ArrayList<Integer>list,int i,int j){
        while(i<j){
            int temp=list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
    }
}

  
