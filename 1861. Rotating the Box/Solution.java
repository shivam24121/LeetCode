class Solution {
    public char[][] rotateTheBox(char[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;

        char[][] res=new char[n][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][m-i-1]=grid[i][j];
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(res[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        for(int j=0;j<m;j++){
            for(int i=n-1;i>=0;i--){
                if(res[i][j]=='.'){
                    for(int k=i-1;k>=0;k--){
                        if(res[k][j]=='*'){
                            break;
                        }
                        if(res[k][j]=='#'){
                            res[k][j]='.';
                            res[i][j]='#';
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}

/*

1 2      5 3 1
3 4      6 4 2
5 6


*/
