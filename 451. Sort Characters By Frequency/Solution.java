class Solution {
    public String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>l=new ArrayList<>(map.keySet());
        Collections.sort(l,(a,b)->map.get(b)-map.get(a));

        for(char i:l){
            for(int j=0;j<map.get(i);j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
