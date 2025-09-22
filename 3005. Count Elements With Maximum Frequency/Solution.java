class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int maxFreq=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()>maxFreq){
                maxFreq=entry.getValue();
            }
        }
        int sum=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()==maxFreq){
                sum+=entry.getValue();
            }
        }
        return sum;
    }
}
