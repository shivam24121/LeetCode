class Solution {

    int[][] dp=new int[2001][2001];
    HashMap<Integer,Integer>map;

    public boolean canCross(int[] stones) {

        if(stones[1]!=1)return false;
        map=new HashMap<Integer,Integer>();

        for(int[] i:dp){
            Arrays.fill(i,-1);
        }

        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }

        return solve(stones,0,0);
    }
    public boolean solve(int[] stone,int idx,int jump){
        if(idx==stone.length-1)return true;

        if(dp[idx][jump]!=-1)return dp[idx][jump]==1;

        boolean fl=false;

        for(int i=jump-1;i<=jump+1;i++){

            if(i<=0)continue;

            int next=stone[idx]+i;

            if(!map.containsKey(next))continue;

            if(solve(stone,map.get(next),i)==true){
                dp[idx][jump]=1;
                return true;
            }
        }
        dp[idx][jump]=0;
        return false;
    }
}
