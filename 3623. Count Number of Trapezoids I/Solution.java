class Solution {
    int mod=(int)1e9+7;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Long>map=new HashMap<>();
        for(int[] e:points){
            Integer y=e[1];
            map.put(y,map.getOrDefault(y,0L)+1L);
        }
        for(Map.Entry<Integer,Long>entry:map.entrySet()){
            long val=entry.getValue();
            long newVal=((val*(val-1))/2)%mod;
            entry.setValue(newVal);
        }
        long res=0,ans=0;
        for(long i:map.values()){
            res=(res+(ans*i)%mod)%mod;
            ans=(ans+i)%mod;
        }
        return (int)res;
    }
}
