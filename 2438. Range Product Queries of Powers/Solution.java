import java.util.*;
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int x=queries.length;
        int mod=(int) (1e9 +7);
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<32;i++){
            if((n &(1<<i))!=0){
                l.add(1<<i);
            }
        }
        int[] res=new int[x];
        for(int i=0;i<x;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            long product=1;
            for(int j=left;j<=right;j++){
                product=(product*l.get(j))%mod;
            }
            res[i]=(int)product;
        }
        return res;
    }
}
