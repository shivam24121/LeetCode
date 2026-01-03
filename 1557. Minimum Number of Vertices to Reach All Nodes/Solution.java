class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res=new ArrayList<>();
        int[] inDegree=new int[n];

        for(int i=0;i<edges.size();i++){
            int x=edges.get(i).get(1);
            inDegree[x]++;
        }
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
