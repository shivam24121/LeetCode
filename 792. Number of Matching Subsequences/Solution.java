class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        var map=new HashMap<String,Integer>();
        var res=0;

        for(var i:words){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(var e:map.entrySet()){

            var str=e.getKey();
            if(valid(s,str)){
                res+=e.getValue();
            }
        }
        return res;
    }
    public boolean valid(String s1,String s2){
        int i=0,j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            i++;
        }
        return j==s2.length();
    }
}
