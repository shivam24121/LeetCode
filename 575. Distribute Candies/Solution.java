class Solution {
    public int distributeCandies(int[] candy) {

        Map<Integer,Integer>map=new HashMap<>();
        for(int i:candy){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        int n=candy.length;

        return Math.min(n/2,map.size());
    }
}
