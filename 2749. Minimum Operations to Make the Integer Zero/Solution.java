class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=0;i<65;i++){
            long x=(long)num1-(long)i*num2;
            if(x<0)continue;
            if(x<i)continue;
            int bit_ct=Long.bitCount(x);
            if(bit_ct<=i)return i;
        }
        return -1;
    }
}
