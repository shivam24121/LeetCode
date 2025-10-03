class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int[] nums=new int[26];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            nums[c-'a']++;
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(nums[i]>0){
                pq.add(new int[]{i,nums[i]});
            }
        }
        StringBuilder sb=new StringBuilder();
        
        while(pq.size()>1){
            int[] first=pq.poll();
            int[]  sec=pq.poll();

            sb.append((char)(first[0]+'a'));
            sb.append((char)(sec[0]+'a'));

            if(--first[1]>0)pq.offer(first);
            if(--sec[1]>0)pq.offer(sec);
        }
        if(!pq.isEmpty()){
            if(pq.peek()[1]>1)return "";
            sb.append((char)(pq.poll()[0]+'a'));
        }
        return sb.toString();
    }
}
