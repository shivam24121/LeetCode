class Solution {
    public int numberOfWays(String s) {
        int n=s.length();
        int mod=(int)1e9+7;
        long res=1;

        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='S'){
                list.add(i);
            }
        }
        if(list.size()<=1)return 0;
        if(list.size()==2)return 1;
        if(list.size()%2==1)return 0;
        
        for(int i=2;i<list.size();i+=2){
            int temp=list.get(i)-list.get(i-1);
            res=(res*temp)%mod;
        }
        return (int)res;
    }
}
