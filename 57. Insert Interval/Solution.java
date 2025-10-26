class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]>res=new ArrayList<>();
        int i=0;

        while(i<n){
            if(intervals[i][1]<newInterval[0]){
                res.add(intervals[i]);
            }
            else if(intervals[i][0]>newInterval[1]){
                break;
            }
            else{
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
            i++;
        }
        res.add(newInterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
