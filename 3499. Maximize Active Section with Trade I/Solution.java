class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        
        int n=s.length();

        int res=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                res++;
            }
        }
        ArrayList<Integer>type=new ArrayList<>();
        ArrayList<Integer>grp=new ArrayList<>();

        s='1'+s+'1';

        for(int i=0;i<s.length();i++){

            int c=s.charAt(i)-'0';

            int j=i;

            while(j<s.length() && s.charAt(j)==s.charAt(i)){
                j++;
            }
            int len=j-i;

            type.add(c);
            grp.add(len);

            i=j-1;
        }

        int temp=0;

        for(int i=1;i<type.size()-1;i++){
            if(type.get(i)==1 && type.get(i-1)==0 && type.get(i+1)==0){
                temp=Math.max(grp.get(i-1)+grp.get(i+1),temp);
            }
        }
        return res+temp;
    }
}
