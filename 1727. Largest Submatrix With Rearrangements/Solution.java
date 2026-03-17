class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        int max=0;

        int[] height=new int[m];

        for(int i=1;i<=n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i-1][j]==1){
                    height[j]++;
                }
                else{
                    height[j]=0;
                }
            }

            // for(int x=0;x<m;x++){
            //     System.out.print(height[x]+" ");
            // }
            // System.out.println();

            int[] temp=height.clone();
            sortRev(temp);
            for(int x=0;x<m;x++){
                max=Math.max(max,temp[x]*(x+1));
            }
        }
        return max;
    }
    public void sortRev(int[] a){
        Arrays.sort(a);
        int l=0,r=a.length-1;
        while(l<r){
            a[l]=a[l]+a[r]-(a[r]=a[l]);
            l++;
            r--;
        }
    }
}
