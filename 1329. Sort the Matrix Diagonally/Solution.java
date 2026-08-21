class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int n=mat.length;
        int m=mat[0].length;
        Map<Integer,ArrayList<Integer>>map=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                int mask=i-j;

                map.putIfAbsent(mask,new ArrayList<>());
                map.get(mask).add(mat[i][j]);
            }
        }
        for(var e:map.values()){
            Collections.sort(e);
        }
        int[][] res=new int[n][m];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){

                int key=i-j;
                res[i][j]=map.get(key).get(map.get(key).size()-1);
                map.get(key).remove(map.get(key).size()-1);
            }
        }
        return res;
    }
}
