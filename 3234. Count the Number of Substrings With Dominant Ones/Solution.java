class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] prefix=new int[n];
        prefix[0]=s.charAt(0)=='1'?1:0;

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+(s.charAt(i)=='1'?1:0);
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int oneCt=prefix[j]-(i>0?prefix[i-1]:0);
                int length=j-i+1;
                int zeroCt=length-oneCt;

                int z=zeroCt*zeroCt;

                if(z>oneCt){
                    int skip=zeroCt*zeroCt-oneCt;
                    j+=skip-1;
                }
                else if(z==oneCt){
                    res++;
                }
                else{
                    res++;

                    int k=(int)Math.sqrt(oneCt)-zeroCt;
                    int next=k+j;

                    if(next>=n){
                        res+=n-j-1;
                        break;
                    }
                    else{
                        res+=k;
                    }
                    j=next;
                }
            }
        }
        return res;
    }
}
