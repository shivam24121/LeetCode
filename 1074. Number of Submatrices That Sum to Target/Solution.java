class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ct=0;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                Map<Integer,Integer> hm=new HashMap<>();
                hm.put(0,1);
                int sum=0;
                for(int k=0;k<m;k++){
                    int cur=matrix[k][j]-(i>0?matrix[k][i-1]:0);
                    sum+=cur;
                    if(hm.containsKey(sum-target)){
                        ct+=hm.get(sum-target);
                    }
                    hm.put(sum,hm.getOrDefault(sum,0)+1);
                }
            }
        }
        return ct;
    }
}
