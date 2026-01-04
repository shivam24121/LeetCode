class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int res=0;
        for(int i:nums){
            res+=factors(i);
        }
        return res;
    }
    public int factors(int x){
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=1;i*i<=x;i++){
            if(x%i==0){
                res.add(i);
                if(i!=x/i){
                    res.add(x/i);
                }
            }
        }
        int sum=0;
        if(res.size()==4){
            for(int i=0;i<4;i++){
                sum+=res.get(i);
            }
        }
        return sum;
    }
}
