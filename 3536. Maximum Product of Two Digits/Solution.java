class Solution {
    public int maxProduct(int n) {
        
        String s=String.valueOf(n);
        int min=0;
        int max=0;

        for(char c:s.toCharArray()){
            
            int num=c-'0';
            
            if(num>max){
                min=max;
                max=num;
            }
            else if(num>min){
                min=num;
            }
        }
        return min*max;
    }
}
