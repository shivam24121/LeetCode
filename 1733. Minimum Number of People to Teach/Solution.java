class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> set=new HashSet<>();
        for(int[] i:friendships){
            int u=i[0]-1;
            int v=i[1]-1;

            Set<Integer> talk=new HashSet<>();
            for(int j:languages[u]){
                talk.add(j);
            }
            boolean canTalk=false;
            for(int k:languages[v]){
                if(talk.contains(k)){
                    canTalk=true;
                    break;
                }
            }
            if(!canTalk){
                set.add(u);
                set.add(v);
            }
        }
        int[] ct=new int[n+1];
        int max=0;
        for(int i:set){
            for(int j:languages[i]){
                ct[j]++;
                max=Math.max(max,ct[j]);
            }
        }
        return set.size()-max;
    }
}
