class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        
        int n=a.length;
        int[] res=new int[n];

        int[] freq=new int[51];

        int ct=0;

        for(int i=0;i<n;i++){

            int one=a[i];
            int two=b[i];

            freq[one]++;

            if(freq[one]==0){
                ct++;
            }

            freq[two]--;

            if(freq[two]==0){
                ct++;
            }

            res[i]=ct;
        }
        return res;
    }
}
