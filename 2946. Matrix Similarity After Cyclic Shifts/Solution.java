class Solution {
    public boolean areSimilar(int[][] mat, int k) {

        int n=mat.length;
        int m=mat[0].length;
        k=k%m;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
  
                int exp;
                if(j%2==0){
                    exp=(j-k+m)%m;
                }
                else{
                    exp=(j+k)%m;
                }
                if(mat[i][j]!=mat[i][exp]){
                    return false;
                }
            }
        }
        return true;
    }
}
