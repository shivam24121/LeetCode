class Solution {
    public long getDescentPeriods(int[] prices){
        int n=prices.length;
        long res=n;

        long temp=0;
        for(int i=1;i<n;i++){
            if((prices[i]+1)==prices[i-1]){
                temp++;
            }
            else{
                long curr=(temp*(temp+1))/2;
                res+=curr;
                temp=0; 
            }
            // System.out.println(temp+" ");
            // System.out.println();
            // System.out.println(res+" ");
        }
        if(temp!=0){
            long curr=(temp*(temp+1))/2;
            res+=curr;
        }
        return res;
    }
}
