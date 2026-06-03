class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character,Integer>mapP=new HashMap<>();

        int n=s.length();
        int m=p.length();

        for(int i=0;i<m;i++){
            char c=p.charAt(i);
            mapP.put(c,mapP.getOrDefault(c,0)+1);
        }
        Map<Character,Integer>mapS=new HashMap<>();

        for(int i=0;i<Math.min(n,m);i++){
            char c=s.charAt(i);
            mapS.put(c,mapS.getOrDefault(c,0)+1);
        }
        List<Integer>list=new ArrayList<>();

        if(mapP.equals(mapS)){
            list.add(0);
        }

        for(int i=m;i<n;i++){

            mapS.put(s.charAt(i),mapS.getOrDefault(s.charAt(i),0)+1);
            mapS.put(s.charAt(i-m),mapS.getOrDefault(s.charAt(i-m),0)-1);

            if(mapS.get(s.charAt(i-m))==0){
                mapS.remove(s.charAt(i-m));
            }

            if(mapP.equals(mapS)){
                list.add(i-m+1);
            }
        }
        return list;
    }
}
