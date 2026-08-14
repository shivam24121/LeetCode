class Solution {
    public int maximumLengthSubstring(String s) {
        
        int n=s.length();
        Map<Character,Integer>map=new HashMap<>();

        int res=0;
        int l=0;

        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>2){
                char temp=s.charAt(l);
                map.put(temp,map.getOrDefault(temp,0)-1);
                if(map.get(temp)==0){
                    map.remove(temp);
                }
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
