class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ct=numBottles;
        int rem=numBottles;
        while(rem>=numExchange){
            int temp=rem/numExchange;
            ct+=temp;
            rem=(rem%numExchange)+temp;
        }
        return ct;
    }
}
