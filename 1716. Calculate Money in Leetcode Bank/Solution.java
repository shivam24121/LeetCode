class Solution {
    public int totalMoney(int n) {
        int week=n/7;
        int day=n%7;

        int rem=(2*week+day+1)*day/2;
        int full=week*28+7*(week*(week-1)/2);
        return rem+full;
    }
} 
