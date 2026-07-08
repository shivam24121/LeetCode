class Solution {

    int mod=(int)1e9+7;

    String[] segTree;

    void intialize(int n,String s){

        segTree=new String[n*4];
        Arrays.fill(segTree,"");
        build(0,0,n-1,s);
    }
    void build(int idx,int l,int r,String s){

        if(l==r){
            segTree[idx]=s.charAt(l)=='0'?"":String.valueOf(s.charAt(l));
            return;
        }
        int mid=l+(r-l)/2;

        build(idx*2+1,l,mid,s);
        build(idx*2+2,mid+1,r,s);

        segTree[idx]=segTree[idx*2+1]+segTree[idx*2+2];
    }
    public String query(int idx,int l,int r,int qL,int qR){

        if(l>=qL && r<=qR){
            return segTree[idx];
        }
        if(r<qL || l>qR){
            return "";
        }
        int mid=l+(r-l)/2;

        String left=query(idx*2+1,l,mid,qL,qR);
        String right=query(idx*2+2,mid+1,r,qL,qR);

        return left+right;
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        
        int n=s.length();
        intialize(n,s);
        long[] prefix=new long[n];

        prefix[0]=s.charAt(0)-'0';

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+(s.charAt(i)-'0');
        }
        int idx=0;
        int[] res=new int[queries.length];

        for(int[] e:queries){

            int l=e[0];
            int r=e[1];

            long sum=prefix[r];
            if(l>0){
                sum-=prefix[l-1];
            }

            String concat=query(0,0,n-1,l,r);
            // System.out.println(concat);
            // System.out.println(concat==""?"tr":"fl");
            long temp=concat.equals("")?0L:Long.parseLong(concat);

            // System.out.println(temp+" "+sum);

            long ans=(1L*temp*sum)%mod;

            res[idx++]=(int)ans;

        }

        // for(int i=0;i<3*n;i++){
        //     System.out.println(i+" "+segTree[i]);
        // }

        return res;
    }
}
