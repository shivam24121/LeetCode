class Solution {
    public int[] arrayRankTransform(int[] a) {
        
        int n=a.length;
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=a[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(x,y)->Integer.compare(x[0],y[0]));

        Integer prev=null;
        int curr=0;

        int[] res=new int[n];

        for(int i=0;i<n;i++){

            int val=arr[i][0];
            int idx=arr[i][1];

            if(prev==null || prev!=val){
                curr++;
                prev=val;
            }
            res[idx]=curr;
        }
        return res;
    }
}
