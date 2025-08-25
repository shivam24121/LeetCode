class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] res=new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i+j;
                map.putIfAbsent(key,new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }
        int idx=0;
        for(int i=0;i<=m+n-2;i++){
            List<Integer> temp=map.get(i);
            if(i%2==0){
                Collections.reverse(temp);
            }
            for(int j=0;j<temp.size();j++){
                res[idx++]=temp.get(j);
            }
        }
        return res;
    }
}
