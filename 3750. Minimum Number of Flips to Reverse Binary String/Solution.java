class Solution {
    public int minimumFlips(int n) {
        String s=Integer.toBinaryString(n);
        String temp=new StringBuilder(s).reverse().toString();

        int cost=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=temp.charAt(i))cost++;
        }
        return cost;
    }
}
