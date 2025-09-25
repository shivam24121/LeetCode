class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] a=new int[n];

        for(int i=0;i<n;i++){
            a[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                a[j]=triangle.get(i).get(j)+Math.min(a[j],a[j+1]);
            }
        }
        return a[0];
    }
}
