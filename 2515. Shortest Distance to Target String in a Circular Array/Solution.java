class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        
        int res=Integer.MAX_VALUE;

        ArrayList<Integer>list=new ArrayList<>();

        for(int i=0;i<words.length;i++){
            String s=words[i];
            if(s.equals(target)){
                list.add(i);
            }
        } 
        if(list.size()==0){
            return -1;
        }
        for(int i=0;i<list.size();i++){
            int d=Math.abs(list.get(i)-startIndex);
            res=Math.min(res,d);
            res=Math.min(res,words.length-d);
        }
        return res;
    }
}
