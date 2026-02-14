class Solution {
    public int prefixConnected(String[] words, int k) {
        //k 

        var map=new HashMap<String,Integer>();
        int n=words.length;

        for(int i=0;i<n;i++){
            String curr=words[i];

            if(curr.length()<k)continue;

            String sub=curr.substring(0,k);
            map.put(sub,map.getOrDefault(sub,0)+1);
        }
        int res=0;
        
        for(var e:map.entrySet()){
            int val=e.getValue();
            if(val>=2){
                res++;
            }
        }
        return res;
    }
}
