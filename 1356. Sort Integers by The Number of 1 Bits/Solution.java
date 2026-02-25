class Solution {
    public int[] sortByBits(int[] arr) {
        ArrayList<int[]>list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(new int[]{arr[i],Integer.bitCount(arr[i])});
        }
        Collections.sort(list,(a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=list.get(i)[0];
        }
        return res;
    }
}
