class Solution {
    public long numberOfWeeks(int[] milestones) {
        int max=Arrays.stream(milestones).max().getAsInt();
        long sum=0;
        for(int i:milestones){
            sum+=i;
        }
        long rest=sum-max;
        return max>=rest+1?rest*2+1:sum;
    }
}
