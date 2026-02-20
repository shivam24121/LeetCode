class Solution {
    public String makeLargestSpecial(String s) {
        int n=s.length();
        int sum=0;
        int start=0;
        ArrayList<String>res=new ArrayList<>();

        for(int i=0;i<n;i++){
            sum+=s.charAt(i)=='1'?1:-1;
            if(sum==0){
                String curr='1'+makeLargestSpecial(s.substring(start+1,i))+'0';
                res.add(curr);
                start=i+1;
            }
        }
        Collections.sort(res,Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String i:res){
            sb.append(i);
        }
        return sb.toString();
    }
}
