import java.util.ArrayList;
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       ArrayList<Integer> small=new ArrayList<>();
       ArrayList<Integer> equal=new ArrayList<>();
       ArrayList<Integer> large=new ArrayList<>();
       int i;
       for(i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                small.add(nums[i]);
            }
            else if(nums[i]==pivot){
                equal.add(nums[i]);
            }
            else{
                large.add(nums[i]);
            }
            
       }
       int index=0;
       for(i=0;i<small.size();i++)nums[index++]=small.get(i);
       for(i=0;i<equal.size();i++)nums[index++]=equal.get(i);
       for(i=0;i<large.size();i++)nums[index++]=large.get(i);
       return nums;
    }
}
