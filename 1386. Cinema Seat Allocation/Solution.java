class Solution {
    public int maxNumberOfFamilies(int n, int[][] arr) {
        
        int res=0;
        Map<Integer,Integer>map=new HashMap<>();

        for(int[] e:arr){

            int row=e[0];
            int col=e[1];

            map.put(row,map.getOrDefault(row,0)|(1<<col));
        }
        res+=(n-map.size())*2;

        for(var e:map.entrySet()){

            int row=e.getKey();
            int mask=e.getValue();

            int one  =(1<<2)|(1<<3)|(1<<4)|(1<<5);
            int two  =(1<<4)|(1<<5)|(1<<6)|(1<<7);
            int three=(1<<6)|(1<<7)|(1<<8)|(1<<9);

            boolean a=(one&mask)==0?true:false;
            boolean b=(two&mask)==0?true:false;
            boolean c=(three&mask)==0?true:false;

            if(a && c){
                res+=2;
            }
            else if(a | b | c){
                res+=1;
            }
        }
        return res;
    }
}
