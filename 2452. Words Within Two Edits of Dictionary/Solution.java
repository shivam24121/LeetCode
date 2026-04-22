class Solution {
    public List<String> twoEditWords(String[] word, String[] str) {
        
        List<String>res=new ArrayList<>();

        for(int i=0;i<word.length;i++){

            String a=word[i];

            for(int j=0;j<str.length;j++){

                int diff=0;
                String b=str[j];

                for(int k=0;k<str[j].length();k++){

                    if(a.charAt(k)!=b.charAt(k)){
                        diff++;
                        if(diff>2){
                            break;
                        }
                    }
                }
                if(diff<=2){
                    res.add(a);
                    break;
                }
            }
        }
        return res;
    }
}
