class Solution {

    int n,m;

    public String generateString(String s1, String s2) {
        
        n=s1.length();
        m=s2.length();

        int len=n+m-1;

        char[] arr=new char[len];

        Arrays.fill(arr,'*');

        // fill all the the T with the s2 chars;

        for(int i=0;i<n;i++){
            if(s1.charAt(i)=='T'){
                for(int j=0;j<m;j++){
                    if(arr[i+j]!='*' && arr[i+j]!=s2.charAt(j)){
                        return "";
                    }
                    arr[i+j]=s2.charAt(j);
                }
            }
        }

        // now we have to ensure that if s1 charAt =='F' then waha substring should be different the s2
        // so agar for lexographically a, invalid aaaya then b will definetly work for sure;

        // we can mark all * as possible options to change because we cant change chars obtain from T;

        BitSet bs=new BitSet(len);

        for(int i=0;i<len;i++){
            if(arr[i]=='*'){
                arr[i]='a';
                bs.set(i,true);
            }
        }

        for(int i=0;i<n;i++){
            if(s1.charAt(i)=='F'){
                String temp=new String(arr,i,m);
                boolean fl=false;
                if(temp.equals(s2)){
                    for(int j=m-1;j>=0;j--){
                        if(bs.get(i+j)==true){
                            arr[i+j]='b';
                            fl=true;
                            break;
                        }
                    }
                    if(!fl)return "";
                }
            }
        }
        return new String(arr);
    }
}
