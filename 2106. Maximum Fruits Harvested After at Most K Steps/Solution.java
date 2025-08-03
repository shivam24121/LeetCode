class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left=0,sum=0,max=0;
        for(int right=0;right<fruits.length;right++){
            sum+=fruits[right][1];
            while(left<=right && steps(fruits[left][0],fruits[right][0],startPos)>k){
                sum-=fruits[left][1];
                left++;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
    private int steps(int left , int right , int cur){
        int low=Math.abs(cur-left)+(right-left);
        int high=Math.abs(cur-right)+(right-left);
        return Math.min(high,low);
    }
}
