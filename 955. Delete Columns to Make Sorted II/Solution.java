class Solution {
    public int minDeletionSize(String[] strs) {
        int row=strs.length;
        int col=strs[0].length();
        boolean[] check=new boolean[row];

        int delete=0;

        for(int i=0;i<col;i++){
            boolean sort=false;
            for(int j=0;j<row-1;j++){
                if(!check[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
                    sort=true;
                    break;
                }
            }
            if(sort){
                delete++;
                continue;
            }
            for(int j=0;j<row-1;j++){
                if(!check[j] && strs[j].charAt(i)<strs[j+1].charAt(i)){
                    check[j]=true;
                }
            }
        }
        return delete;
    }
}
