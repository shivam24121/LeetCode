class Solution {

    //       up,rt,dn,le
    
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};

    public int robotSim(int[] arr, int[][] stone) {
        
        int n=arr.length;

        Set<String>set=new HashSet<>();

        for(int[] e:stone){
            int x=e[0];
            int y=e[1];
            set.add(x+"_"+y);
        }

        // System.out.println(set);

        int x=0;
        int y=0;

        int dir=0;
        int res=0;

        for(int i=0;i<n;i++){

            int curr=arr[i];

            if(curr==-1){
                
                dir=(dir+1)%4;
            }
            else if(curr==-2){

                dir=(dir+4-1)%4;
            }
            else{

                for(int j=1;j<=curr;j++){

                    int xx=x+dx[dir];
                    int yy=y+dy[dir];

                    // System.out.println(xx+" "+yy);

                    if(set.contains(xx+"_"+yy)){
                        break;
                    }
                    x=xx;
                    y=yy;
                }
                // System.out.print(res);

                res=Math.max(res,(int)Math.pow(x,2)+(int)Math.pow(y,2));

                // System.out.println(" "+res);
            }
        }
        return res;
    }
}


/*


***    *-*   ***
-@*    *@*   *@-
***    ***   ***


*/
