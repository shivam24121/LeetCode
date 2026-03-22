class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        if(valid(mat,target)){
            return true;
        }
        int[][] temp=rotate(mat);
        for(int i=1;i<=3;i++){
            if(valid(temp,target)){
                return true;
            }
            temp=rotate(temp);
        }
        return false;
    }
    public int[][] rotate(int[][] arr){
        int n=arr.length;
        int[][] res=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[j][n-i-1]=arr[i][j];
            }
        }
        return res;
    }
    public boolean valid(int[][] a,int[][] b){
        int n=a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!=b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}


/*


1 2 3    7 4 1
4 5 6    8 5 2
7 8 9    9 6 3 

1,1 -> 1,3
1,2 -> 2,3
2,2 -> 2,2
3,3 -> 3,1
2,3 -> 3,2
3,1 -> 1,1

*/
