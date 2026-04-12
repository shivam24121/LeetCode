class Solution {

    int n;
    int[][][] dp;

    public int minimumDistance(String word) {
        
        n=word.length();

        dp=new int[n][27][27];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return solve(0,-1,-1,word);
    }
    public int solve(int idx,int h1,int h2,String s){

        if(idx==n){
            return 0;
        }

        // System.out.println(idx+" "+h1+" "+h2);

        if(h1!=-1 && h2!=-1 && dp[idx][h1][h2]!=-1){
            return dp[idx][h1][h2];
        }

        int pickOne=0;
        int pickTwo=0;

        int curr=s.charAt(idx)-'A';

        int currX=curr/6;
        int currY=curr%6;


        if(h1!=-1){

            int prevFx=h1/6;
            int prevFy=h1%6;

            pickOne=Math.abs(currX-prevFx)+Math.abs(currY-prevFy);
        }

        if(h2!=-1){

            int prevSx=h2/6;
            int prevSy=h2%6;

            pickTwo=Math.abs(currX-prevSx)+Math.abs(currY-prevSy);
        }

        int c1=pickOne+solve(idx+1,curr,h2,s);

        int c2=pickTwo+solve(idx+1,h1,curr,s);

        if(h1!=-1 && h2!=-1){
            dp[idx][h1][h2]=Math.min(c1,c2);
        }

        return Math.min(c1,c2);
    }
}
