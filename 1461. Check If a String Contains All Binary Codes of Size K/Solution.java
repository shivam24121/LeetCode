class Solution {
    public boolean hasAllCodes(String s, int k) {
        var set=new HashSet<String>();
        for(int i=0;i<=s.length()-k;i++){
            String curr=s.substring(i,i+k);
            set.add(curr);
        }
        //System.out.println(set);
        return set.size()==(long)Math.pow(2,k);
    }
}
