class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(int i=0;i<operations.length;i++){
            String curr=operations[i];
            if(curr.indexOf('+')==-1){
                res--;
            }
            else{
                res++;
            }
        }
        return res;
    }
}
