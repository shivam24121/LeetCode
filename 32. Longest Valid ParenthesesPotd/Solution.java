class Solution {
    public int longestValidParentheses(String s) {
        
        int n=s.length();
        int res=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int curr=0;

        for(int i=0;i<n;i++){

            if(s.charAt(i)=='('){
                curr++;
            }
            else{
                curr--;
            }
            if(curr<0){
                curr=0;
                // System.out.println("yaha "+i);
                map.clear();
                map.put(0,i);
            }
            else{
                if(map.containsKey(curr)){
                    res=Math.max(res,i-map.get(curr));
                }
                else{
                    map.put(curr,i);
                }
            }
        }
        return res;
    }
}
