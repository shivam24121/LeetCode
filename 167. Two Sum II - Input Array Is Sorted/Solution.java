class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            int check=numbers[l]+numbers[r];
            if(check==target){
                return new int[]{l+1,r+1};
            }
            else if(check>target){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}
