class Solution {
    public int compress(char[] chars) {
       int index=0;
       int i=0;
       int n=chars.length;
       while(i<n){
            char curr=chars[i];
            int count=0;
            while(i<n && chars[i]==curr){
                count++;
                i++;
            }
            chars[index]=curr;
            index++;
            if(count>1){
                String temp=String.valueOf(count);
                for(int x=0;x<temp.length();x++){
                    chars[index++]=temp.charAt(x);
                }
            }
       }
       return index;
    }
}
