class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> t=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> p=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    p.add(1);
                }
                else{
                    int temp=t.get(i-1).get(j-1)+t.get(i-1).get(j);
                    p.add(temp);
                }
            }
            t.add(p);
        }
        return t;
    }
}
