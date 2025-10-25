class Solution {
    public boolean isNumber(String s) {
        boolean dot=false;
        boolean e=false;
        boolean digit=false;
        int pm=0;
        s=s.toLowerCase();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='+' || c=='-'){
                if(pm==2){
                    return false;
                }
                if(i>0 && s.charAt(i-1)!='e'){
                    return false;
                }
                if(i==s.length()-1){
                    return false;
                }
                pm++;
            }
            else if(Character.isDigit(c)){
                digit=true;
            }
            else if(c=='e'){
                if(e){
                    return false;
                }
                if(i==s.length()-1){
                    return false;
                }
                if(!digit){
                    return false;
                }
                e=true;
            }
            else if(c=='.'){
                if(!digit && i==s.length()-1){
                    return false;
                }
                if(dot || e){
                    return false;
                }
                dot=true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
