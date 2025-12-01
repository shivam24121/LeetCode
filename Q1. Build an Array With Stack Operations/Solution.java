class Solution {
    public List<String> buildArray(int[] target, int n) {
        int idx=1;
        List<String>res=new ArrayList<>();
        int i=0;
        while(i<target.length){
            if(target[i]==idx){
                res.add("Push");
                idx++;
                i++;
            }
            else{
                res.add("Push");
                res.add("Pop");
                idx++;
            }
        }
        return res;
    }
}
