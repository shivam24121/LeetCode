class Robot {

    String[] dir={"North","West","South","East"};

    int[] dx={0,-1,0,1};
    int[] dy={1,0,-1,0};

    int n;
    int m;

    int curr;

    int x,y;

    public Robot(int width, int height) {
        n=height;
        m=width;

        curr=3;

        x=0;
        y=0;
    }
    
    public void step(int num) {

        int perimeter=(n+m-2)*2;
        num=num%perimeter;

        if(x==0 && y==0 && num==0){
            curr=2;
            return;
        }

        for(int i=1;i<=num;i++){

            int nx=x+dx[curr];
            int ny=y+dy[curr];

            if(nx<0 || nx>=m || ny<0 || ny>=n){
                curr=(curr+1)%4;

                nx=x+dx[curr];
                ny=y+dy[curr];
            }

            x=nx;
            y=ny;

        }
    }
    
    public int[] getPos() {
        
        return new int[]{x,y};
    }
    
    public String getDir() {
        
        return dir[curr];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
