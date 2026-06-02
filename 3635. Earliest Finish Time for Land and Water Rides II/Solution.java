class Solution {
    public int earliestFinishTime(int[] landStart, int[] landTime, int[] waterStart, int[] waterTime) {
        
        int n=landStart.length;
        int m=waterStart.length;

        int res=Integer.MAX_VALUE;

        ArrayList<int[]>a=new ArrayList<>();

        for(int i=0;i<n;i++){
            a.add(new int[]{landStart[i],landTime[i]});
        }

        ArrayList<int[]>b=new ArrayList<>();

        for(int i=0;i<m;i++){
            b.add(new int[]{waterStart[i],waterTime[i]});
        }

        // Collections.sort(a,(x,y)->Integer.compare(x[0],y[0]));
        // Collections.sort(b,(x,y)->Integer.compare(x[0],y[0]));

        int finishLandFirst=Integer.MAX_VALUE;
        int waterAfterLand=Integer.MAX_VALUE;
        int finishWaterFirst=Integer.MAX_VALUE;
        int landAfterWater=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            int st=a.get(i)[0];
            int tm=a.get(i)[1];

            finishLandFirst=Math.min(finishLandFirst,st+tm);

        }
        for(int i=0;i<m;i++){

            int st=b.get(i)[0];
            int tm=b.get(i)[1];

            finishWaterFirst=Math.min(finishWaterFirst,st+tm);
            
        }
        for(int i=0;i<n;i++){

            int st=a.get(i)[0];
            int tm=a.get(i)[1];

            int temp=Math.max(finishWaterFirst,st);
            
            landAfterWater=Math.min(landAfterWater,temp+tm);
        }
        for(int i=0;i<m;i++){

            int st=b.get(i)[0];
            int tm=b.get(i)[1];

            int temp=Math.max(finishLandFirst,st);
            
            waterAfterLand=Math.min(waterAfterLand,temp+tm);
        }
        return Math.min(waterAfterLand,landAfterWater);
    }
}
