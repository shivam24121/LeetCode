class Solution {

    int n;
    int max=1;

    public int longestBalanced(String s) {
        
        n=s.length();

        int ct=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                ct++;
            }
            else{
                ct=1;
            }
            max=Math.max(max,ct);
        }

        max=Math.max(max,solve(s,'a','b'));
        max=Math.max(max,solve(s,'a','c'));
        max=Math.max(max,solve(s,'b','c'));

        int a=0,b=0,c=0;
        Map<String,Integer>map=new HashMap<>();
        map.put("0_0",-1);

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='a')a++;
            if(ch=='b')b++;
            if(ch=='c')c++;

            int ab=a-b;
            int ac=a-c;

            String diff=ab+"_"+ac;

            if(a==c && a==b){
                max=Math.max(max,a+b+c);
            }

            if(map.containsKey(diff)){
                max=Math.max(max,i-map.get(diff));
            }
            else{
                map.put(diff,i);
            }
        }
        return max;
    }
    public int solve(String s , char first , char sec){

        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int a=0,b=0;
        int ans=0;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(c==first){
                a++;
            }
            if(c==sec){
                b++;
            }
            if(c!=first && c!=sec){
                map.clear();
                a=0;
                b=0;
            }
            if(a==b){
                max=Math.max(max,a+a);
            }
            int diff=a-b;

            if(map.containsKey(diff)){
                ans=Math.max(ans,i-map.get(diff));
            }
            else{
                map.put(diff,i);
            }
        }
        return ans;
    }
}
