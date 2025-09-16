class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer>res=new ArrayList<>();
        for(int i:nums){
            while(!res.isEmpty()){
                int prev=res.get(res.size()-1);
                int g=gcd(prev,i);
                if(g==1){
                    break;
                }
                else{
                    res.remove(res.size()-1);
                    long lcm=(long)i*prev/g;
                    i=(int)lcm;
                }
            }
            res.add(i);
        }
        return res;
    }
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
