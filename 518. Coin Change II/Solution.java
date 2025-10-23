class Solution {
    public int change(int amount, int[] coins) {
        int[] t=new int[amount+1];
        t[0]=1;

        for(int i:coins){
            for(int j=i;j<=amount;j++){
                t[j]+=t[j-i];
            }
        }
        return t[amount];
    }
}
