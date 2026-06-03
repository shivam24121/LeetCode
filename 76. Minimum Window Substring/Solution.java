class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character,Integer>mapT=new HashMap<>();
        Map<Character,Integer>mapS=new HashMap<>();

        for(char c:t.toCharArray()){
            mapT.put(c,mapT.getOrDefault(c,0)+1);
        }

        int unique=mapT.size();

        int l=0;
        int match=0;
        int res=Integer.MAX_VALUE;
        int idx=0;

        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            mapS.put(c,mapS.getOrDefault(c,0)+1);

            if(mapT.containsKey(c) && mapT.get(c).equals(mapS.get(c))){
                match++;
            }
            while(match==unique){
                
                int len=r-l+1;
                if(len<res){
                    res=len;
                    idx=l;
                }

                char tempC=s.charAt(l);
                mapS.put(tempC,mapS.getOrDefault(tempC,0)-1);
                if(mapT.containsKey(tempC) && mapS.get(tempC)<mapT.get(tempC)){
                    match--;
                }
                l++;
            }
        }
        return res==Integer.MAX_VALUE?"":s.substring(idx,idx+res);
    }
}
