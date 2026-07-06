class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        
        int n=arr.length;
        int res=n;

        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        int end=arr[0][1];

        for(int i=1;i<n;i++){
            
            int currStart=arr[i][0];
            int currEnd=arr[i][1];

            if(currStart>=end){
                end=currEnd;
            }
            else if(currEnd<=end){
                res--;
            }
            end=Math.max(end,currEnd);
        }
        return res;
    }
}

// 1 4
// 2 8 
// 3 6
