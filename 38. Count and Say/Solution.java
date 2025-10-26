class Solution {
    public String countAndSay(int n) {

        //base case
        if(n==1)return "1";

        // process
        String say=countAndSay(n-1);
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<say.length();i++){
            char c=say.charAt(i);
            int ct=1;
            while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1)){
                i++;
                ct++;
            }
            sb.append(ct).append(c);
        }
        return sb.toString();
    }
}
