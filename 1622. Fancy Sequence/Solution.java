class Fancy {


    static ArrayList<Long>adj;
    final static int mod=(int)1e9+7;
    long add=0;
    long mul=1;

    public Fancy() {
        adj=new ArrayList<>();
    }
    
    public void append(int val) {
        long x=((val-add)%mod+mod)%mod;
        x=(x*power(mul,mod-2)%mod)%mod;
        adj.add(x);
    }
    
    public void addAll(int inc) {
        add=(add+inc)%mod;
    }
    
    public void multAll(int m) {
        add=(add*m)%mod;
        mul=(mul*m)%mod;
    }
    
    public int getIndex(int idx) {
        if(adj.size()<=idx)return -1;
        int x=(int)(adj.get(idx)*mul)%mod;
        x=(int)(x+add)%mod;
        return x;
    }
    public long power(long b,long exp){
        long res=1;
        while(exp>0){
            if((exp&1)==1){
                res=(res*b)%mod;
                exp--;
            }
            b=(b*b)%mod;
            exp/=2;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
