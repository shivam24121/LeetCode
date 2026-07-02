class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        
        int n=arr.length;
        Map<Integer,Integer>map=new HashMap<>();

        map.put(0,1);
        int odd=0;

        int res=0;

        for(int i=0;i<n;i++){
            if(arr[i]%2==1){
                odd++;
            }
            res+=map.getOrDefault(odd-k,0);
            map.put(odd,map.getOrDefault(odd,0)+1);
        }
        return res;
    }
}
