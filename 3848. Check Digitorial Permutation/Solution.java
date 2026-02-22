class Solution {
    public boolean isDigitorialPermutation(int n) {
        long sum=0;
        int temp=n;
        while(temp>0){
            int dig=temp%10;
            sum+=fact(dig);
            temp/=10;
        }
        return ana(String.valueOf(n),String.valueOf(sum));
    }
    public long fact(int n){
        if(n<=1)return 1;
        long res=1;
        for(int i=2;i<=n;i++){
            res*=i;
        }
        return res;
    }
    public boolean ana(String a,String b){
        if(a.length()!=b.length())return false;
        var map=new HashMap<Character,Integer>();
        for(int i=0;i<a.length();i++){
            char one=a.charAt(i);
            char two=b.charAt(i);
            map.put(one,map.getOrDefault(one,0)+1);
            map.put(two,map.getOrDefault(two,0)-1);
        }
        for(var i:map.values()){
            if(i!=0)return false;
        }
        return true;
    }
}
