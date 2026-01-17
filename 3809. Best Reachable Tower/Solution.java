class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int max=-1;
        int[] res={-1,-1};

        for(int[] e:towers){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            int dis=Math.abs(u-center[0])+Math.abs(v-center[1]);

            if(dis<=radius){
                if(w>max){
                    max=w;
                    res[0]=u;res[1]=v;
                }
                else if(w==max){
                    if(u<res[0] || (u==res[0] && res[1]>v)){
                        res[0]=u;
                        res[1]=v;
                    }
                }
            }
        }
        return res;
    }
}
