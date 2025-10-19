class Solution {
    public String rotated(String s,int k){
        int n=s.length();
        String first=s.substring(0,n-k);
        String last=s.substring(n-k);
        return last+first;
    }
    public String findLexSmallestString(String s, int a, int b) {
        HashSet <String> set=new HashSet<>();
        Deque <String> q=new LinkedList<>();

        q.offer(s);
        set.add(s);
        String ans=s;

        while(!q.isEmpty()){
            String curr=q.poll();
            if(curr.compareTo(ans)<0){
                ans=curr;
            }
            //op1 me add to odd;

            char[] arr=curr.toCharArray();
            for(int i=1;i<arr.length;i+=2){
                int d=(arr[i]-'0'+a)%10;
                arr[i]=(char)(d+'0');
            }
            String op1=new String(arr);

            //op2 me we will rotate;

            String op2=rotated(curr,b);

            if(!set.contains(op1)){
                set.add(op1);
                q.offer(op1);
            }
            if(!set.contains(op2)){
                set.add(op2);
                q.offer(op2);
            }
        }
        return ans;
    }
}
