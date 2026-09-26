class Solution {
    public String evaluate(String s, List<List<String>> arr) {
        
        Map<String,String>map=new HashMap<>();

        for(var a:arr){

            String key=a.get(0);
            String val=a.get(1);

            map.put(key,val);
        }
        
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='('){

                int j=i+1;

                while(s.charAt(j)!=')'){
                    j++;
                }
                String val=s.substring(i+1,j);
                // System.out.println(val);

                res.append(map.getOrDefault(val,"?"));
                i=j;
            }
            else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
